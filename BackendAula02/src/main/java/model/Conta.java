package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Conta {
	private String numero; 
	private String titular;
	private double saldo;
	private LocalDateTime data;
	
	// Construtor padrão (opcional o Java já teria criado) 
	// Toda nova conta gar um bônus de R$ 50
	public Conta() {
		this.saldo = 50.0;
		this.data = LocalDateTime.now();
	}
	
	// Construtor Completo
	public Conta(String numero, String titular, double saldo) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo + 50.0;
		this.data = LocalDateTime.now();
	}
	
	// Construtor Personalizado
	public Conta(String numero, String titular) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = 50.0;
		this.data = LocalDateTime.now();
	}
	
	// Criar os Getters e Setters
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getTitular() {
		return titular;
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public LocalDateTime getData() {
		return data;
	}
	
}




