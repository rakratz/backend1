package Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.Professor;
import Model.Titulacao;



public class ProferssorController {
	
	private final List<Professor> professores = new ArrayList<>();
	
	public void cadastrar(String codigo, String nome, Date dataNascimento, 
						  String email, String telefone, String disciplina, 
						  Titulacao titulacao) {
		
		Professor professor = new Professor(codigo, nome, dataNascimento, email, telefone, disciplina, titulacao);
		
		professores.add(professor);
		
	}
	
	public List<Professor> listar(){
		return new ArrayList<>(professores);
	}
}
