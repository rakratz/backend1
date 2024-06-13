package app;

import java.sql.SQLException;
import controller.BookController;
import repository.BookRepository;
import view.BookView;

public class Main {

	public static void main(String[] args) {
		BookRepository bookRepository  = new BookRepository(); 
		BookView bookView = new BookView();
		BookController bookController = new BookController(bookRepository, bookView);
		boolean exit = false;

		while (!exit) {
			bookView.printMenu();
			int choice = Integer.parseInt(bookView.getInput("Escolha uma opção: "));
			try {
				switch (choice) {
					case 1:
						bookController.createBook();
						break;
					case 2:
						bookController.readBook();
						break;	
					case 5:
						bookController.listBook();
						break;	
					case 6:
						exit = true;
						break;
					default:
						bookView.printMessage("Opção inválida. Tente novamente.");

				}
			} catch (SQLException e) {
                bookView.printMessage("An error occurred: " + e.getMessage());
            }

		}
	}
}
