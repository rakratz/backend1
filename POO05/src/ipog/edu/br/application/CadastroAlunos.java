package ipog.edu.br.application;

import java.util.Scanner;
import ipog.edu.br.controller.AlunoController;

public class CadastroAlunos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AlunoController alunoController = new AlunoController();
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar Aluno");
            System.out.println("2 - Mostrar Alunos");
            System.out.println("3 - Sair");
            int opcao = scanner.nextInt();
            if (opcao == 1) {
                System.out.println("Digite o nome do aluno:");
                scanner.nextLine(); // Consumir a quebra de linha pendente
                String nome = scanner.nextLine();
                System.out.println("Digite a idade do aluno:");
                int idade = scanner.nextInt();
                alunoController.adicionarAluno(nome, idade);
            } else if (opcao == 2) {
                alunoController.mostrarAlunos();
            } else if (opcao == 3) {
                System.out.println("Encerrando o programa.");
                break;
            } else {
                System.out.println("Opção inválida! Digite novamente.");
            }
        }
        scanner.close();
    }
}

