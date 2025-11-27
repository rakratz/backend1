package app;


import java.util.Scanner;

import DAO.ContaDAO;
import controller.ContaController;
import view.ContaView;

public class Main {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ContaView view = new ContaView(sc);
		ContaDAO dao = new ContaDAO();
		ContaController controller = new ContaController(view, dao);
		
		controller.iniciar();
		sc.close();

	}

}
