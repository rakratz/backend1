package Model;

public class PessoalOperacional extends Terceiro{

	private String funcao;

	public PessoalOperacional() {
		super();
	}

	public PessoalOperacional(String nome, int idade, String empresa, String funcao) {
		super(nome, idade, empresa);
		this.funcao = funcao;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
}
