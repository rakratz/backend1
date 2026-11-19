package View;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import Model.Produto;

public class ProdutoView {
	
	private final Scanner teclado;

	public ProdutoView(Scanner teclado) {
		this.teclado = teclado;
	}
	
	public Produto lerProduto() {
		
		System.out.println("\n=== Cadastro de Produto ===");

		System.out.print("Nome: ");
		String nome = teclado.nextLine().trim();
		
		System.out.print("Preço: ");
		String textoPreco = teclado.nextLine().trim().replace(',', '.');
		BigDecimal preco = new BigDecimal(textoPreco);
		
		System.out.print("Quantidade: ");
		int quantidade = Integer.parseInt(teclado.nextLine().trim());
		
		
		return new Produto(0, nome, preco, quantidade);
	}
	
	public void mostrarProdutos(List<Produto> produtos) {
	    System.out.println("\n=== Produtos cadastrados ===");

	    if (produtos.isEmpty()) {
	        mostrarMensagem("Nenhum produto cadastrado.");
	        return;
	    }

	    for (Produto produto : produtos) {
	        System.out.println(produto);
	    }
	}
	
	public void mostrarMensagem(String mensagem) {
		System.out.println(mensagem);
	}

}
