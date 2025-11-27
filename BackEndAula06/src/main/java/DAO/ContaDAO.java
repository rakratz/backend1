package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

public class ContaDAO {

    public void salvar(Conta conta) {
        String sql = "INSERT INTO contas " +
                "(numero, titular, saldo, tipo, limite, taxa_rendimento) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, conta.getNumero());
            ps.setString(2, conta.getTitular());
            ps.setDouble(3, conta.getSaldo());

            if (conta instanceof ContaCorrente cc) {
                ps.setString(4, "CC");
                ps.setDouble(5, cc.getLimite());
                ps.setNull(6, Types.DECIMAL);
            } else if (conta instanceof ContaPoupanca cp) {
                ps.setString(4, "CP");
                ps.setNull(5, Types.DECIMAL);
                ps.setDouble(6, cp.getTaxaRendimento());
            } else {
                throw new IllegalArgumentException("Tipo de conta desconhecido");
            }

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    conta.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Conta> listarTodos() {
        List<Conta> contas = new ArrayList<>();
        String sql = "SELECT * FROM contas";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Conta conta = mapResultSetToConta(rs);
                if (conta != null) {
                    contas.add(conta);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contas;
    }

    public Conta buscarPorId(int id) {
        String sql = "SELECT * FROM contas WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToConta(rs);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void atualizar(Conta conta) {
        String sql = "UPDATE contas SET numero = ?, titular = ?, saldo = ?, " +
                "tipo = ?, limite = ?, taxa_rendimento = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, conta.getNumero());
            ps.setString(2, conta.getTitular());
            ps.setDouble(3, conta.getSaldo());

            if (conta instanceof ContaCorrente cc) {
                ps.setString(4, "CC");
                ps.setDouble(5, cc.getLimite());
                ps.setNull(6, Types.DECIMAL);
            } else if (conta instanceof ContaPoupanca cp) {
                ps.setString(4, "CP");
                ps.setNull(5, Types.DECIMAL);
                ps.setDouble(6, cp.getTaxaRendimento());
            } else {
                throw new IllegalArgumentException("Tipo de conta desconhecido");
            }

            ps.setInt(7, conta.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM contas WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // --- auxiliar ---
    private Conta mapResultSetToConta(ResultSet rs) throws SQLException {
        String tipo = rs.getString("tipo");

        if ("CC".equals(tipo)) {
            return new ContaCorrente(
                    rs.getInt("id"),
                    rs.getString("numero"),
                    rs.getString("titular"),
                    rs.getDouble("saldo"),
                    rs.getDouble("limite")
            );
        } else if ("CP".equals(tipo)) {
            return new ContaPoupanca(
                    rs.getInt("id"),
                    rs.getString("numero"),
                    rs.getString("titular"),
                    rs.getDouble("saldo"),
                    rs.getDouble("taxa_rendimento")
            );
        }
        return null;
    }
}