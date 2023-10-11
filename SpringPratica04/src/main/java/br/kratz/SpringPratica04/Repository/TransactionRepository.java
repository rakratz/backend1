package br.kratz.SpringPratica04.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.kratz.SpringPratica04.Model.Transaction.Transaction;



public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
