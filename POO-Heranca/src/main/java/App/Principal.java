package App;

import Controller.PessoaController;
import Service.PessoaService;
import View.PessoaView;

public class Principal {

	public static void main(String[] args) {
		
		PessoaService service = new PessoaService();
		
		PessoaView view = new PessoaView();
		
		PessoaController controller = new PessoaController(service, view);
		
		controller.iniciar();

	}

}
