package br.edu.ipog.controller;

import br.edu.ipog.model.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ipog.dao.Conexao;


@ManagedBean
@ViewScoped
public class ProdutoBean {
    private Produto produto = new Produto();
    private List<Produto> produtos = new ArrayList<>();

    public Produto getProduto() {
        return produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
    
    public List<Produto> listarProdutos() {
        List<Produto> produtosListados = new ArrayList<>();
        
        try (Connection conexaoJDBC = Conexao.getConexao()) {
            String query = "SELECT * FROM produtos";
            
            try (PreparedStatement stmt = conexaoJDBC.prepareStatement(query);
                 ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    Produto produto = new Produto();
                    produto.setId(resultSet.getLong("id"));
                    produto.setNome(resultSet.getString("nome"));
                    produto.setValor(resultSet.getDouble("valor"));
                    produtosListados.add(produto);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar os produtos: " + e.getMessage());
        }
        
        return produtosListados;
    }

    public void excluirProduto(Produto produto) {
        try (Connection conexaoJDBC = Conexao.getConexao()) {
            String query = "DELETE FROM produtos WHERE id = ?";
            
            try (PreparedStatement stmt = conexaoJDBC.prepareStatement(query)) {
                stmt.setLong(1, produto.getId());
                stmt.executeUpdate();
                System.out.println("Produto excluído do banco de dados.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir o produto do banco de dados: " + e.getMessage());
        }
    }

    public void cadastrar() {
    	System.out.println("Cadastro de Produto");
    	System.out.println("Nome do Produto: " + produto.getNome());
        System.out.println("Valor do Produto: " + produto.getValor());
        
        salvarProduto(); // Chamada ao método salvarProduto()
         
        produtos.add(produto);
        produto = new Produto(); // Limpa os campos após o cadastro
    }
    
    public void editarProduto(Produto produto) {
        this.produto = produto; // Carregar o produto para edição
    }
    
    public void salvarEdicao() {
        try (Connection conexaoJDBC = Conexao.getConexao()) {
            String query = "UPDATE produtos SET nome = ?, valor = ? WHERE id = ?";

            try (PreparedStatement stmt = conexaoJDBC.prepareStatement(query)) {
                stmt.setString(1, produto.getNome());
                stmt.setDouble(2, produto.getValor());
                stmt.setLong(3, produto.getId());

                stmt.executeUpdate();
                System.out.println("Produto editado e salvo no banco de dados.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar e salvar o produto no banco de dados: " + e.getMessage());
        } finally {
            produto = new Produto(); // Limpa os campos após a edição
        }
    }
    
    public void salvarProduto() {
        try (Connection conexaoJDBC = Conexao.getConexao()) {
            String query = "INSERT INTO produtos (nome, valor) VALUES (?, ?)";

            try (PreparedStatement stmt = conexaoJDBC.prepareStatement(query)) {
                stmt.setString(1, produto.getNome());
                stmt.setDouble(2, produto.getValor());

                stmt.executeUpdate();
                System.out.println("Produto salvo no banco de dados.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar o produto no banco de dados: " + e.getMessage());
        }
    }
}