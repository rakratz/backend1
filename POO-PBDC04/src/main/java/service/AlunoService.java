package service;

import model.Aluno;
import repository.AlunoRepository;
import java.util.List;

public class AlunoService {

    private AlunoRepository repository = new AlunoRepository();

    public void cadastrarAluno(Aluno aluno) {
        if (aluno.getNome() == null || aluno.getNome().isEmpty()) {
            throw new RuntimeException("Nome é obrigatório");
        }

        if (aluno.getMatricula() == null || aluno.getMatricula().isEmpty()) {
            throw new RuntimeException("Matrícula é obrigatória");
        }

        repository.salvar(aluno);
    }

    public List<Aluno> listarAlunos() {
        return repository.listar();
    }

    public void atualizarAluno(Aluno aluno) {
        repository.atualizar(aluno);
    }

    public void excluirAluno(int id) {
        repository.excluir(id);
    }
}