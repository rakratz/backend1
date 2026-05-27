package controller;

import model.Funcionario;

import service.FuncionarioService;

import java.util.List;

public class FuncionarioController {
	
	private FuncionarioService service = new FuncionarioService();
	
	public void adcionarFuncionario(Funcionario funcionario) {
		service.adicionarFuncionario(funcionario);
	}

	public List<Funcionario> listarFuncionarios(){
		return service.listarFuncionarios();
	}
	
	public boolean removerFuncionario(String nome) {
		return service.removerFuncionario(nome);
	}
}
