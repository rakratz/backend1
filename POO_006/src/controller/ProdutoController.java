package controller;

import java.util.ArrayList;
import java.util.List;

import model.Produto;
import repository.ProdutoRepository;

public class ProdutoController {
	private ProdutoRepository repository = new ProdutoRepository();

	public void adicionarProduto(String nome, double preco) {
		Produto novo = new Produto(nome, preco);
		repository.salvar(novo);
		System.out.println("Novo Produto cadastrado com sucesso...");
	}

	public void listarProdutos() {
		List<Produto> produtos = repository.listarTodos();
		if (produtos.isEmpty()) {
			System.out.println("Não há Produtos cadastrado...");
		} else {
			produtos.forEach(System.out::println);
		}
	}

	public void atualizarProduto(int id, String nome, double preco) {
		Produto produto_atualizado = new Produto(id, nome, preco);
		repository.atualizar(produto_atualizado);
		System.out.println("Produto atualizado com sucesso...");
		
	}

	public void removerProduto(int id) {
		repository.remover(id);
		System.out.println("Produto apagado com sucesso...");
	}
}
