package App;

import Model.Pessoa;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pessoa professor = new Pessoa();
		professor.setNome("Ricardo de Andrade Kratz");
		professor.setIdade(48);
		professor.setEmail("ricardo.kratz@ipog.edu.br");
		System.out.println(professor.getNome());
		System.out.println(professor.getIdade());
		System.out.println(professor.getEmail());
		
	}

}
