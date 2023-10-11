package br.kratz.SpringPratica04.Model.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.kratz.SpringPratica04.Model.User.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Entity(name = "transactions") // Esta classe é uma entidade mapeada para um banco de dados com o nome "transactions".
@Table(name = "transactions") // A tabela do banco de dados associada a esta entidade também é chamada "transactions".
@EqualsAndHashCode(of = "id") // Gera automaticamente métodos equals() e hashCode() com base no campo "id".
public class Transaction {

    @Id // Indica que o campo "id" é a chave primária da tabela.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração de valores para o campo "id" (neste caso, autoincremento).
    private Long id; // Campo que armazena o identificador único da transação.
    private BigDecimal amount; // Valor da transação (usando BigDecimal para precisão em valores monetários).
    
    @ManyToOne // Indica que a transação está associada a um usuário pagador (payer).
    @JoinColumn(name = "payer_id") // Define a coluna na tabela que mantém a referência ao usuário pagador.
    private User payer; // Objeto do tipo User representando o usuário que fez o pagamento.

    @ManyToOne // Indica que a transação está associada a um usuário beneficiário (payee).
    @JoinColumn(name = "payee_id") // Define a coluna na tabela que mantém a referência ao usuário beneficiário.
    private User payee; // Objeto do tipo User representando o usuário que recebeu o pagamento.

    private LocalDateTime transactionTime; // Data e hora da transação.

	public Transaction(Long id, BigDecimal amount, User payer, User payee, LocalDateTime transactionTime) {
		this.id = id;
		this.amount = amount;
		this.payer = payer;
		this.payee = payee;
		this.transactionTime = transactionTime;
	}

	public Transaction() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public User getPayer() {
		return payer;
	}

	public void setPayer(User payer) {
		this.payer = payer;
	}

	public User getPayee() {
		return payee;
	}

	public void setPayee(User payee) {
		this.payee = payee;
	}

	public LocalDateTime getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(LocalDateTime transactionTime) {
		this.transactionTime = transactionTime;
	}
}
