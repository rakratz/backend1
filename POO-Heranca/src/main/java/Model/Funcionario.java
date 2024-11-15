package Model;

public class Funcionario extends Pessoa{
	private String Cargo;
	
	public Funcionario(){
		
	}
	
	public Funcionario(int id, String nome, int idade, String Cargo){
		super(id, nome, idade);
		this.Cargo = Cargo;
	}

	public String getCargo() {
		return Cargo;
	}

	public void setCargo(String cargo) {
		Cargo = cargo;
	}

	@Override
	public String toString() {
		return "Funcionario [Cargo=" + Cargo + "]";
	}

	
}
