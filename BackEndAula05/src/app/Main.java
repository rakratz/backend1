package app;

import Repository.ProdutoRepository;
import controller.ProdutoController;
import view.ProdutoView;

public class Main {

	public static void main(String[] args) {
		ProdutoRepository repository = new ProdutoRepository();
		ProdutoView view = new ProdutoView();
		ProdutoController controller = new ProdutoController(repository, view);
		controller.iniciar();
	}

}
