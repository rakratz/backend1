package view;

import model.Conta;

public class ContaView {

	public static void main(String[] args) {
		Conta c1 = new Conta();
		c1.setNumero("001-1");
		c1.setTitular("Heuber");
		c1.setSaldo(50);
		
		Conta c2 = new Conta("002-1", "Ricardo Kratz", 100);
		double deposito = c2.getSaldo() + 400.0;
		c2.setSaldo(deposito);
		
		
		Conta c3 = new Conta("003-1", "Joelma");
		c3.setSaldo(20);
		
		double saque = c3.getSaldo() - 100.0;
		c3.setSaldo(saque);
		
		System.out.println("Numero de C1: " + c1.getNumero());
		System.out.println("Títular de C1: " + c1.getTitular());
		System.out.println("Saldo de C1: " + c1.getSaldo());
		System.out.println("Data e Hora de Abertura de C1: " + c1.getData());
		System.out.println("");
		
		System.out.println("Numero de C2: " + c2.getNumero());
		System.out.println("Títular de C2: " + c2.getTitular());
		System.out.println("Saldo de C2: " + c2.getSaldo());
		System.out.println("Data e Hora de Abertura de C2: " + c2.getData());
		System.out.println("");
		
		System.out.println("Numero de C3: " + c3.getNumero());
		System.out.println("Títular de C3: " + c3.getTitular());
		System.out.println("Saldo de C3: " + c3.getSaldo());
		System.out.println("Data e Hora de Abertura de C3: " + c3.getData());
		
	}

}
