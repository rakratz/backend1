package repository;

import model.Aluno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {

    public void salvar(Aluno aluno) {
        String sql = "INSERT INTO aluno (nome, cpf, email, matricula, curso) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getEmail());
            stmt.setString(4, aluno.getMatricula());
            stmt.setString(5, aluno.getCurso());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar aluno", e);
        }
    }

    public List<Aluno> listar() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM aluno";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Aluno aluno = new Aluno(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("email"),
                    rs.getString("matricula"),
                    rs.getString("curso")
                );

                alunos.add(aluno);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar alunos", e);
        }

        return alunos;
    }

    public void atualizar(Aluno aluno) {
        String sql = "UPDATE aluno SET nome=?, cpf=?, email=?, matricula=?, curso=? WHERE id=?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getEmail());
            stmt.setString(4, aluno.getMatricula());
            stmt.setString(5, aluno.getCurso());
            stmt.setInt(6, aluno.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar aluno", e);
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM aluno WHERE id=?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir aluno", e);
        }
    }
}