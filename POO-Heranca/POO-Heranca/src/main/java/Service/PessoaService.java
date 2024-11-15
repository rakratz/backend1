package Service;

import java.util.ArrayList;
import java.util.List;

import Model.*;


public class PessoaService {
	private List<Pessoa> pessoas = new ArrayList<>();
	
	private int idCounter = 1;
	
	public void adicionarCliente(String nome, int idade, String email) {
        Cliente cliente = new Cliente(idCounter++, nome, idade, email);
        pessoas.add(cliente);
    }
	
	public void adicionarFuncionario(String nome, int idade, String cargo) {
        Funcionario funcionario = new Funcionario(idCounter++, nome, idade, cargo);
        pessoas.add(funcionario);
    }
	
	public List<Pessoa> listarPessoas() {
        return pessoas;
    }
	
	public Pessoa encontrarPessoaPorId(int id) {
        return pessoas.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
	
	public boolean editarPessoa(int id, String nome, int idade, String extraInfo) {
        Pessoa pessoa = encontrarPessoaPorId(id);
        if (pessoa == null) return false;

        pessoa.setNome(nome);
        pessoa.setIdade(idade);

        if (pessoa instanceof Cliente cliente) {
            cliente.setEmail(extraInfo);
        } else if (pessoa instanceof Funcionario funcionario) {
            funcionario.setCargo(extraInfo);
        }
        return true;
    }
	
	public boolean removerPessoa(int id) {
        Pessoa pessoa = encontrarPessoaPorId(id);
        return pessoa != null && pessoas.remove(pessoa);
    }
}
