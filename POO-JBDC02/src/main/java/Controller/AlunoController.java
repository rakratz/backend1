package Controller;

import Model.Aluno;
import Service.AlunoService;

import java.sql.SQLException;
import java.util.List;

public class AlunoController {
    private final AlunoService alunoService = new AlunoService();

    public List<Aluno> listarAlunos() throws SQLException {
        return alunoService.listarTodos();
    }

    public void adicionarAluno(String nome, int idade, String curso) throws SQLException {
        Aluno aluno = new Aluno(0, nome, idade, curso);
        alunoService.inserir(aluno);
    }

    public void atualizarAluno(int id, String nome, int idade, String curso) throws SQLException {
        Aluno aluno = new Aluno(id, nome, idade, curso);
        alunoService.atualizar(aluno);
    }

    public void removerAluno(int id) throws SQLException {
        alunoService.excluir(id);
    }
}
