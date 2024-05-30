package Model;

public class ProfessorAutonomo extends Terceiro{

	private String cnpj;

	public ProfessorAutonomo() {
		super();
	}

	public ProfessorAutonomo(String nome, int idade, String empresa, String cnpj) {
		super(nome, idade, empresa);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
}
