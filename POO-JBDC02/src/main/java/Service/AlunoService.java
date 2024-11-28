package Service;

import Model.Aluno;
import Util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoService {

    public List<Aluno> listarTodos() throws SQLException {
        String sql = "SELECT * FROM Alunos";
        List<Aluno> alunos = new ArrayList<>();

        try (Connection conexao = DatabaseConnection.getConnection();
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Aluno aluno = new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("curso")
                );
                alunos.add(aluno);
            }
        }
        return alunos;
    }

    public void inserir(Aluno aluno) throws SQLException {
        String sql = "INSERT INTO Alunos (nome, idade, curso) VALUES (?, ?, ?)";

        try (Connection conexao = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {

            pstmt.setString(1, aluno.getNome());
            pstmt.setInt(2, aluno.getIdade());
            pstmt.setString(3, aluno.getCurso());
            pstmt.executeUpdate();
        }
    }

    public void atualizar(Aluno aluno) throws SQLException {
        String sql = "UPDATE Alunos SET nome = ?, idade = ?, curso = ? WHERE id = ?";

        try (Connection conexao = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {

            pstmt.setString(1, aluno.getNome());
            pstmt.setInt(2, aluno.getIdade());
            pstmt.setString(3, aluno.getCurso());
            pstmt.setInt(4, aluno.getId());
            pstmt.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM Alunos WHERE id = ?";

        try (Connection conexao = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
