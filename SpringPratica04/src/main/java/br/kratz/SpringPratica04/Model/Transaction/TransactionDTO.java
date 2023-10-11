package br.kratz.SpringPratica04.Model.Transaction;

import java.math.BigDecimal;

public record TransactionDTO(
		
		BigDecimal amount,
		Long payerId,
		Long payeeId
) {

}
