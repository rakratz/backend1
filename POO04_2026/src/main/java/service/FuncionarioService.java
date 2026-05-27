package service;

import model.Funcionario;

import java.util.ArrayList;

import java.util.List;

public class FuncionarioService {

	private List<Funcionario> funcionarios = new ArrayList<>();
	
	public void adicionarFuncionario(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}
	
	public List<Funcionario> listarFuncionarios(){
		return funcionarios;
	}
	
	public boolean removerFuncionario(String nome) {
	    for (int i = 0; i < funcionarios.size(); i++) {

	        Funcionario funcionario = funcionarios.get(i);

	        if (funcionario.getNome().equalsIgnoreCase(nome)) {
	            funcionarios.remove(i);
	            return true;
	        }
	    }
	    return false;
	}
}


