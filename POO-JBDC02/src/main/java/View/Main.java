package View;

import Controller.AlunoController;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AlunoController controller = new AlunoController();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Sistema de Gestão de Alunos ---");
            System.out.println("1. Listar alunos");
            System.out.println("2. Adicionar aluno");
            System.out.println("3. Atualizar aluno");
            System.out.println("4. Remover aluno");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner após nextInt()

            try {
                switch (opcao) {
                    case 1:
                        System.out.println("\n--- Lista de Alunos ---");
                        controller.listarAlunos().forEach(System.out::println);
                        break;

                    case 2:
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        
                        // Verificar se a idade é um número inteiro válido
                        int idade = 0;
                        boolean idadeValida = false;
                        while (!idadeValida) {
                            System.out.print("Idade: ");
                            try {
                                idade = scanner.nextInt();
                                idadeValida = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Por favor, insira um número válido para a idade.");
                                scanner.nextLine(); // Limpar o buffer do scanner
                            }
                        }
                        scanner.nextLine(); // Limpar o buffer após leitura da idade

                        System.out.print("Curso: ");
                        String curso = scanner.nextLine();
                        controller.adicionarAluno(nome, idade, curso);
                        System.out.println("Aluno adicionado com sucesso!");
                        break;

                    case 3:
                        System.out.print("ID do aluno a atualizar: ");
                        int idAtualizar = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer após leitura do ID
                        System.out.print("Novo Nome: ");
                        String novoNome = scanner.nextLine();
                        System.out.print("Nova Idade: ");
                        int novaIdade = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer após leitura da idade
                        System.out.print("Novo Curso: ");
                        String novoCurso = scanner.nextLine();
                        controller.atualizarAluno(idAtualizar, novoNome, novaIdade, novoCurso);
                        System.out.println("Aluno atualizado com sucesso!");
                        break;

                    case 4:
                        System.out.print("ID do aluno a remover: ");
                        int idRemover = scanner.nextInt();
                        controller.removerAluno(idRemover);
                        System.out.println("Aluno removido com sucesso!");
                        break;

                    case 0:
                        System.out.println("Encerrando o sistema...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } catch (SQLException e) {
                System.err.println("Erro ao executar operação: " + e.getMessage());
            }
        } while (opcao != 0);

        // Fechando o scanner após o laço
        scanner.close();
    }
}
