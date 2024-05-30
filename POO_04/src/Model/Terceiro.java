package Model;

public class Terceiro extends Pessoa{
	private String empresa;

	public Terceiro() {
		super();
	}

	public Terceiro(String nome, int idade, String empresa) {
		super(nome, idade);
		this.empresa = empresa;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
}
