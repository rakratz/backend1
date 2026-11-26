package Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.Aluno;

public class AlunoController {
	
	private final List<Aluno> alunos = new ArrayList<>();
	
	public void cadastrar(String codigo, String nome, Date dataNascimento,
            				 String email, String telefone, String matricula,
            				 Date dataMatricula, String curso, int semestre) {
		
		Aluno aluno = new Aluno(codigo, nome, dataNascimento, email, telefone, 
				                matricula, dataMatricula, curso, semestre);
		
		alunos.add(aluno);
		
	}
	
	public List<Aluno> listar(){
		return new ArrayList<>(alunos);
	}

}
