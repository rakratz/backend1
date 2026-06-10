package controller;

import model.Aluno;
import service.AlunoService;
import java.util.List;

public class AlunoController {

    private AlunoService service = new AlunoService();

    public void cadastrar(String nome, String cpf, String email, String matricula, String curso) {
        Aluno aluno = new Aluno(0, nome, cpf, email, matricula, curso);
        service.cadastrarAluno(aluno);
    }

    public List<Aluno> listar() {
        return service.listarAlunos();
    }

    public void atualizar(int id, String nome, String cpf, String email, String matricula, String curso) {
        Aluno aluno = new Aluno(id, nome, cpf, email, matricula, curso);
        service.atualizarAluno(aluno);
    }

    public void excluir(int id) {
        service.excluirAluno(id);
    }
}