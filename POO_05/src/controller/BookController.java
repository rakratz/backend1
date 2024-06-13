package controller;

import java.sql.SQLException;
import java.util.List;

import model.Book;
import repository.BookRepository;
import view.BookView;

public class BookController {
	private BookRepository bookRepository;
	private BookView bookView;
	
	public BookController() {}
	
	public BookController(BookRepository bookRepository, BookView bookView) {
		this.bookRepository = bookRepository;
		this.bookView = bookView; 
	}

	public void createBook() throws SQLException{
		String title = bookView.getInput("Informe o Título do Livro: ");
		String author = bookView.getInput("Informe o Autor do Livro: ");
		
		Book book = new Book(title, author);
		bookRepository.createBook(book);
		bookView.printMessage("Livro Criado com Sucesso!");
	}

	public void readBook() throws SQLException{
		int id = Integer.parseInt(bookView.getInput("Informe o id do Livro: "));
		Book book = bookRepository.getBook(id);
		bookView.printBookDetails(book);
		
	}

	public void listBook() throws SQLException{

		
	}
}
