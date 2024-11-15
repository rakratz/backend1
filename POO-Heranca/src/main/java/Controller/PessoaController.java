package Controller;

import java.util.List;

import Model.Cliente;
import Model.Funcionario;
import Model.Pessoa;
import Service.PessoaService;
import View.PessoaView;

public class PessoaController {
	private PessoaService service;
    private PessoaView view;
    
    public PessoaController(PessoaService service, PessoaView view) {
        this.service = service;
        this.view = view;
    }
    
    public void iniciar() {
        int opcao;
        do {
            opcao = view.exibirMenu();
            switch (opcao) {
                case 1 -> adicionarCliente();
                case 2 -> adicionarFuncionario();
                case 3 -> listarPessoas();
                case 4 -> editarPessoa();
                case 5 -> removerPessoa();
                case 0 -> view.exibirMensagem("Encerrando...");
                default -> view.exibirMensagem("Opção inválida.");
            }
        } while (opcao != 0);
    }
    
    private void adicionarCliente() {
        String nome = view.obterInput("Nome do Cliente: ");
        int idade = Integer.parseInt(view.obterInput("Idade do Cliente: "));
        String email = view.obterInput("Email do Cliente: ");
        service.adicionarCliente(nome, idade, email);
        view.exibirMensagem("Cliente adicionado com sucesso!");
    }
    
    private void adicionarFuncionario() {
        String nome = view.obterInput("Nome do Funcionário: ");
        int idade = Integer.parseInt(view.obterInput("Idade do Funcionário: "));
        String cargo = view.obterInput("Cargo do Funcionário: ");
        service.adicionarFuncionario(nome, idade, cargo);
        view.exibirMensagem("Funcionário adicionado com sucesso!");
    }
    
    private void listarPessoas() {
        List<Pessoa> pessoas = service.listarPessoas();
        if (pessoas.isEmpty()) {
            view.exibirMensagem("Nenhuma pessoa cadastrada.");
        } else {
            view.exibirLista(pessoas);
        }
    }
    
    private void editarPessoa() {
        int id = Integer.parseInt(view.obterInput("Digite o ID da pessoa que deseja editar: "));
        String nome = view.obterInput("Novo nome: ");
        int idade = Integer.parseInt(view.obterInput("Nova idade: "));
        String extraInfo;
        
        Pessoa pessoa = service.encontrarPessoaPorId(id);
        if (pessoa instanceof Cliente) {
            extraInfo = view.obterInput("Novo email: ");
        } else if (pessoa instanceof Funcionario) {
            extraInfo = view.obterInput("Novo cargo: ");
        } else {
            view.exibirMensagem("Pessoa não encontrada.");
            return;
        }
        
        boolean sucesso = service.editarPessoa(id, nome, idade, extraInfo);
        view.exibirMensagem(sucesso ? "Pessoa editada com sucesso!" : "Erro ao editar pessoa.");
    }
    
    private void removerPessoa() {
        int id = Integer.parseInt(view.obterInput("Digite o ID da pessoa que deseja remover: "));
        boolean sucesso = service.removerPessoa(id);
        view.exibirMensagem(sucesso ? "Pessoa removida com sucesso!" : "Pessoa não encontrada.");
    }
}
