public class ExemploConstrutores {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Alice", 25);
        Pessoa pessoa2 = new Pessoa("Bob", 30);
        Pessoa pessoa3 = new Pessoa();
        
        System.out.println("Nome: " + pessoa1.getNome() + ", Idade: " + pessoa1.getIdade());
        System.out.println("Nome: " + pessoa2.getNome() + ", Idade: " + pessoa2.getIdade());
        System.out.println("Nome: " + pessoa3.getNome() + ", Idade: " + pessoa3.getIdade());
    }
}
