package com.empresa.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "contatos")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String nome;

    @Column(name = "idade")
    private int idade;

    @Column(name = "dataCadastro")
    private LocalDate dataCadastro;

    public Contato() {
    }

    public Contato(int id, String nome, int idade, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.dataCadastro = dataCadastro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    // @Override: Indica que o método está substituindo um método da classe pai (nesse caso, o método toString() da classe Object).
    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
