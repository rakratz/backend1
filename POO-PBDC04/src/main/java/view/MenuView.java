package view;

import controller.AlunoController;
import model.Aluno;
import java.util.Scanner;

public class MenuView {

    private Scanner scanner = new Scanner(System.in);
    private AlunoController alunoController = new AlunoController();

    public void exibirMenu() {
        int opcao;

        do {
            System.out.println("\n=== SISTEMA ACADÊMICO ===");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Atualizar aluno");
            System.out.println("4 - Excluir aluno");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

            case 1:
                cadastrarAluno();
                break;

            case 2:
                listarAlunos();
                break;

            case 3:
                atualizarAluno();
                break;

            case 4:
                excluirAluno();
                break;

            case 0:
                System.out.println("Sistema encerrado.");
                break;

            default:
                System.out.println("Opção inválida.");
        }

        } while (opcao != 0);
    }

    private void cadastrarAluno() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        System.out.print("Curso: ");
        String curso = scanner.nextLine();

        alunoController.cadastrar(nome, cpf, email, matricula, curso);
        System.out.println("Aluno cadastrado com sucesso.");
    }

    private void listarAlunos() {
        for (Aluno aluno : alunoController.listar()) {
            System.out.println(aluno);
        }
    }

    private void atualizarAluno() {
        System.out.print("ID do aluno: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();

        System.out.print("Novo CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Novo e-mail: ");
        String email = scanner.nextLine();

        System.out.print("Nova matrícula: ");
        String matricula = scanner.nextLine();

        System.out.print("Novo curso: ");
        String curso = scanner.nextLine();

        alunoController.atualizar(id, nome, cpf, email, matricula, curso);
        System.out.println("Aluno atualizado com sucesso.");
    }

    private void excluirAluno() {
        System.out.print("ID do aluno: ");
        int id = scanner.nextInt();

        alunoController.excluir(id);
        System.out.println("Aluno excluído com sucesso.");
    }
}