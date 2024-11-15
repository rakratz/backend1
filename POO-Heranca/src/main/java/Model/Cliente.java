package Model;

public class Cliente extends Pessoa{
	private String email;
	
	public Cliente() {
		
	}
	
	public Cliente(int id, String nome, int idade, String email) {
		super(id, nome, idade);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
    public String toString() {
        return super.toString() + ", Email: " + email;
    }
}
