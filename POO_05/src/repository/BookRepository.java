package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.DataBaseConnection;
import model.Book;

public class BookRepository {

	public void createBook(Book book) throws SQLException{
		String sql = "INSERT INTO books (title, author) VALUES (?, ?)";
		 try (Connection conn = DataBaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			 stmt.setString(1, book.getTitle());
			 stmt.setString(2, book.getAuthor());
			 stmt.executeUpdate();
			 
			 ResultSet generatedKeys = stmt.getGeneratedKeys();
			 if (generatedKeys.next()) {
				book.setId(generatedKeys.getInt(1)); 
			 }
		}
		
	}

	public Book getBook(int id) throws SQLException{
		String sql = "SELECT * FROM books WHERE id = ?";
		try (Connection conn = DataBaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
			 stmt.setInt(1, id);
			 ResultSet rs = stmt.executeQuery();
			 if (rs.next()) {
				 return new Book(rs.getInt("id"), rs.getString("title"),  rs.getString("author")); 
			 }
		}
		return null;
	}
}
