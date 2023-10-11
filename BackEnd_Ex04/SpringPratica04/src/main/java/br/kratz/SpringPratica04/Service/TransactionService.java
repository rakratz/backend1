package br.kratz.SpringPratica04.Service;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.kratz.SpringPratica04.Model.Transaction.Transaction;
import br.kratz.SpringPratica04.Model.Transaction.TransactionDTO;
import br.kratz.SpringPratica04.Model.User.User;
import br.kratz.SpringPratica04.Repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public Transaction createTransaction(TransactionDTO transaction) throws Exception {

		User payer = this.userService.findUserById(transaction.payerId());
		User payee = this.userService.findUserById(transaction.payeeId());
		
		userService.validateUser(payer, transaction.amount());
		
		boolean isAuthorize = authorizeTransaction();
		
		if (!isAuthorize) {
			throw new Exception("Transação não Autorizada.");
		}
		
		Transaction newTransaction = new Transaction();
		newTransaction.setAmount(transaction.amount());
		newTransaction.setPayer(payer);
		newTransaction.setPayee(payee);
		newTransaction.setTransactionTime(LocalDateTime.now());
		
		payer.setBalance(payer.getBalance().subtract(transaction.amount()));
		payee.setBalance(payee.getBalance().add(transaction.amount()));
		
		this.transactionRepository.save(newTransaction);
		this.userService.saveUser(payer);
		this.userService.saveUser(payee);
		
		return newTransaction;

	}
	
	public boolean authorizeTransaction() {
		
		var response = restTemplate.getForEntity("https://run.mocky.io/v3/8811cb1f-71b1-4777-8626-68f702f9ab80", Map.class);
		if (response.getStatusCode() == HttpStatus.OK) {
			String message = (String) response.getBody().get("message");
			if ("Autorizado".equalsIgnoreCase(message)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		
	}
}
