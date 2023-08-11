package ipog.edu.br.application;

import ipog.edu.br.model.PessoaModel;
import ipog.edu.br.view.PessoaView;
import ipog.edu.br.controller.PessoaController;

public class ExemploMVC {
    public static void main(String[] args) {
        PessoaModel model = new PessoaModel();
        PessoaView view = new PessoaView();
        PessoaController controller = new PessoaController(model, view);
        
        controller.setNome("Alice");
        controller.atualizarView();
        
        controller.setNome("Bob");
        controller.atualizarView();
    }
}

