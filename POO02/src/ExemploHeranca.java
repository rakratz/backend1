class Pessoa {
    private String nome;
    private int idade;

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
}

class Funcionario extends Pessoa {
    private double salario;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}

public class ExemploHeranca {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("João");
        funcionario.setIdade(30);
        funcionario.setSalario(2500.0);

        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Idade: " + funcionario.getIdade());
        System.out.println("Salário: " + funcionario.getSalario());
    }
}
