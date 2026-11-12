package produtos;

import java.sql.SQLException;

import config.Banco;

public class Main {

	public static void main(String[] args) throws SQLException {
		Banco.criarTabela();
		System.out.println("Banco incializado e tabela criada");
	}

}
