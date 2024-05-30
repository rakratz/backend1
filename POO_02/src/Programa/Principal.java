package Programa;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
			Scanner leitura = new Scanner(System.in);
			
			// Pedindo ao usuário a quantidade de carros
			System.out.print("Quantos carros deseja cadatrar? ");
			int num = leitura.nextInt();
			leitura.nextLine(); // Limpar o buffer
			
			// Criar um vetor de carros
			Carro[] carros = new Carro[num];
			
			for (int i = 0; i < num; i++) {
				System.out.println("Cadastro do Carros " + (i+1));
				System.out.print("Modelo: ");
				String modelo = leitura.nextLine();
				
				System.out.print("Cor: ");
				String cor = leitura.nextLine();
				
				System.out.print("Ano: ");
				int ano = leitura.nextInt();
				
				System.out.print("Valor: ");
				double valor = leitura.nextDouble();
				
				// Carro carro = new Carro(modelo, cor, ano, valor);
				Carro carro = new Carro();
				carro.SetModelo(modelo);
				carro.SetCor(cor);
				carro.SetAno(ano);
				carro.SetValor(valor);
				
				// adcionando o carro ao array/vetor
				carros[i] = carro;
				leitura.nextLine(); // Limpar o buffer
			}
			
			// Exibindo os carros cadastrados
			System.out.println("Carros Cadastrados");
			for (Carro carroListagem: carros) {
				System.out.println("Modelo: " + carroListagem.GetModelo());
				System.out.println("Cor: " + carroListagem.GetCor());
				System.out.println("Ano: " + carroListagem.GetAno());
				System.out.println("Valor: " + carroListagem.GetValor());
				System.out.println("");
			}
			
			leitura.close();
	}

}
