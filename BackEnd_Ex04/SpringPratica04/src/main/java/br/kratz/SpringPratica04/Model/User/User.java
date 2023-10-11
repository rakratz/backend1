package br.kratz.SpringPratica04.Model.User;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Entity(name = "users") 
@Table(name = "users") 
@EqualsAndHashCode(of = "id") 
public class User {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; 
    private String name; 
    @Column(unique = true) 
    private String CPF; 
    @Column(unique = true) 
    private String email; 
    private String password; 
    private UserType UserType; 
    private BigDecimal balance; 

    
    
    public User(Long id, String name, String cPF, String email, String password,
			br.kratz.SpringPratica04.Model.User.UserType userType, BigDecimal balance) {
		this.id = id;
		this.name = name;
		CPF = cPF;
		this.email = email;
		this.password = password;
		UserType = userType;
		this.balance = balance;
	}

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return UserType;
	}

	public void setUserType(UserType userType) {
		UserType = userType;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public User(UserDTO dto) {
    	this.name = dto.name();
    	this.CPF = dto.CPF();
    	this.email = dto.email();
    	this.password = dto.password();
    	this.UserType = dto.UserType();
    	this.balance = dto.balance();			
    }
}
