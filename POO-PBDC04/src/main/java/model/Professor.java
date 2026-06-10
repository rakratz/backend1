package model;

public class Professor extends Pessoa {
    private String titulacao;
    private double salario;

    public Professor() {}

    public Professor(int id, String nome, String cpf, String email, String titulacao, double salario) {
        super(id, nome, cpf, email);
        this.titulacao = titulacao;
        this.salario = salario;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return id + " - " + nome + " - " + cpf + " - " + email +
               " - Titulação: " + titulacao + " - Salário: " + salario;
    }
}