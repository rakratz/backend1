package view;

import model.Book;

public class BookView {

	public void printMenu() {
		System.out.println("Menu");
		System.out.println("1 - Criar Livro");
		System.out.println("2 - Ver Livro");
		System.out.println("3 - Atualizar Livro");
		System.out.println("4 - Apagar Livro");
		System.out.println("5 - Listar Livros");
		System.out.println("6 - Sair");
		
	}

	public String getInput(String prompt) {
		System.out.println(prompt);
		return new java.util.Scanner(System.in).nextLine();
	}

	public void printMessage(String message) {
		System.out.print(message);
		
	}

	public void printBookDetails(Book book) {
		if (book != null) {
			System.out.println("ID do Livro: "+book.getId());
			System.out.println("Título do Livro: "+book.getTitle());
			System.out.println("Autor do Livro: "+book.getAuthor());
		} else {
			System.out.println("Livro não encontrado.");
		}
		
	}

}
