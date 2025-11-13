package controller;

import java.util.List;

import Repository.ProdutoRepository;
import model.Produto;
import view.ProdutoView;

public class ProdutoController {
	private ProdutoRepository repository;
	private ProdutoView view;
	
	public ProdutoController(ProdutoRepository repository, ProdutoView view){
		this.repository = repository;
		this.view = view;
	}
	
	public void iniciar() {
		int opcao;
		do {
			opcao = view.menu();
			switch (opcao) {
            	case 1 -> cadastrar();
            	case 2 -> listar();
            	case 0 -> view.mostrarMensagem("Saindo...");
            	default -> view.mostrarMensagem("Opção inválida!");
			}
		} while (opcao !=0);
	}

	private void cadastrar() {
		Produto novo = view.lerDadosProduto();
		repository.salvar(novo);
		view.mostrarMensagem("Produto cadastrado com sucesso! ID: "+novo.getId());
	}
	
	private void listar() {
		List<Produto> produtos = repository.listarTodos();
		view.mostrarProdutos(produtos);
	}
}
