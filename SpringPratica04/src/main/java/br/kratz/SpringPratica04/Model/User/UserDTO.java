package br.kratz.SpringPratica04.Model.User;

import java.math.BigDecimal;

public record UserDTO(	
		
		String name,
		String CPF,
		String email,
		String password,
		UserType UserType,
		BigDecimal balance) {

}
