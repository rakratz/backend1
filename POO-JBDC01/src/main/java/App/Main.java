package App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    // Configurações de conexão
    private static final String URL = "jdbc:mysql://localhost:3306/jbdc_teste2";
    private static final String USUARIO = "root";
    private static final String SENHA = "Aluno@123";

    public static void main(String[] args) {
        // Estabelecendo conexão com o banco de dados
        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");

            // Exibindo antes da alteração
            exibirDados(conexao);

            
            // Inserindo um novo registro
            inserirRegistro(conexao, "Lucas Ferreira", 24, "Engenharia Elétrica");

            // Editando um registro existente (alterar curso para o ID 1)
            editarRegistro(conexao, 1, "Engenharia de Controle e Automação");

            // Excluindo um registro (remover o registro com ID 2)
            excluirRegistro(conexao, 2);

            
            // Exibindo os dados atualizados da tabela
            exibirDados(conexao);

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados ou executar a consulta.");
            e.printStackTrace();
        }
    }
	
 // Método para inserir um novo registro
    private static void inserirRegistro(Connection conexao, String nome, int idade, String curso) throws SQLException {
        String sql = String.format(
            "INSERT INTO Alunos (nome, idade, curso) VALUES ('%s', %d, '%s')",
            nome, idade, curso
        );
        try (Statement stmt = conexao.createStatement()) {
            int linhasAfetadas = stmt.executeUpdate(sql);
            System.out.printf("Registro inserido com sucesso! Linhas afetadas: %d%n", linhasAfetadas);
        }
    }

    // Método para editar um registro existente
    private static void editarRegistro(Connection conexao, int id, String novoCurso) throws SQLException {
        String sql = String.format(
            "UPDATE Alunos SET curso = '%s' WHERE id = %d",
            novoCurso, id
        );
        try (Statement stmt = conexao.createStatement()) {
            int linhasAfetadas = stmt.executeUpdate(sql);
            System.out.printf("Registro atualizado com sucesso! Linhas afetadas: %d%n", linhasAfetadas);
        }
    }

    // Método para excluir um registro
    private static void excluirRegistro(Connection conexao, int id) throws SQLException {
        String sql = String.format("DELETE FROM Alunos WHERE id = %d", id);
        try (Statement stmt = conexao.createStatement()) {
            int linhasAfetadas = stmt.executeUpdate(sql);
            System.out.printf("Registro excluído com sucesso! Linhas afetadas: %d%n", linhasAfetadas);
        }
    }
    
    
	// Método para exibir os dados da tabela
    private static void exibirDados(Connection conexao) throws SQLException {
        String sql = "SELECT * FROM Alunos";
        try (Statement stmt = conexao.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("Dados da tabela Alunos:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                String curso = rs.getString("curso");
                System.out.printf("ID: %d | Nome: %s | Idade: %d | Curso: %s%n", id, nome, idade, curso);
            }
        }
    }
}
