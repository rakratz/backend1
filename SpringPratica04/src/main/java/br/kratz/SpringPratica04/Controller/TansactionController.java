package br.kratz.SpringPratica04.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.kratz.SpringPratica04.Model.Transaction.Transaction;
import br.kratz.SpringPratica04.Model.Transaction.TransactionDTO;
import br.kratz.SpringPratica04.Model.User.User;
import br.kratz.SpringPratica04.Model.User.UserDTO;
import br.kratz.SpringPratica04.Service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TansactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transaction) throws Exception {
       
		Transaction newTransaction = this.transactionService.createTransaction(transaction);
        return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }

}
