package app;

import java.util.ArrayList;
import java.util.List;

import model.Comissionado;
import model.Funcionario;
import model.Horista;
import model.Mensalista;

public class App {

	public static void main(String[] args) {
		List<Funcionario> equipe = new ArrayList<>();
		Comissionado carla = new Comissionado("Carla Silva", "333.333.333-33", 120_000.0, 0.06);
		equipe.add(carla);
		
		Horista  pedro = new Horista("Pedro Lima", "222.222.222-22", 50.0, 160.0);
		equipe.add(pedro);
		
		Mensalista roberto = new Mensalista("Roberto Carlos", "111.111.111-11", 6000.0);
		equipe.add(roberto);
		
		
		System.out.println("=== Folha de Pagamento do Mês ===");
		double total = 0.0;
		for (Funcionario f: equipe) {
			double remuneracao = f.calcularRemuneracao();
			System.out.printf("%s -> R$ %, .2f%n", f.toString(), remuneracao);
			total += remuneracao;
		}
		
		System.out.printf("Total de Folha R$ %, .2f%n", total);
		
		
	}

}
