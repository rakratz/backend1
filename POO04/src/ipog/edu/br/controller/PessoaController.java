package ipog.edu.br.controller;

import ipog.edu.br.model.PessoaModel;
import ipog.edu.br.view.PessoaView;

//Controller
public class PessoaController {
    private PessoaModel model;
    private PessoaView view;
    
    public PessoaController(PessoaModel model, PessoaView view) {
        this.model = model;
        this.view = view;
    }
    
    public void setNome(String nome) {
        model.setNome(nome);
    }
    
    public void atualizarView() {
        view.mostrarDetalhes(model.getNome());
    }

}

