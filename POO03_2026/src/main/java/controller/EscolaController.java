package controller;

import java.util.ArrayList;

import model.Pessoa;

public class EscolaController {
	
	public ArrayList<Pessoa> pessoas = new ArrayList<>();
	
	// Create (Criar)
	public void adcionarPessoa(Pessoa p) {
		pessoas.add(p);
		System.out.println("Pessoa Cadastrada!");
	}
	
	// Read (Ler)
	public void listarPessoas() {
		System.out.println("\nLISTA");
		for (Pessoa p : pessoas) {
			p.exibirDados();
		}
	}
	
	// Update (Editar)
	public void atualizarPessoa(String nomeAntigo, String novoNome) {
		
		
		// Pesquisar se existe essa pessoa
		for (Pessoa p: pessoas) {
			if (p.getNome().equals(nomeAntigo)) {
				p.setNome(novoNome);
				System.out.println("Nome atualizado!");
				return;
			}
		}
		
	}
	
	
	// Delete (Apagar)
	 public void removerPessoa(String nome) {

		 Pessoa pessoaRemover = null;
		 
	        for (Pessoa p : pessoas) {
	            if (p.getNome().equals(nome)
	            ) {

	                pessoaRemover = p;
	            }
	        }

	        if (pessoaRemover != null) {

	            pessoas.remove(pessoaRemover);

	            System.out.println("Pessoa removida!");
	        }
	    }
	
}
