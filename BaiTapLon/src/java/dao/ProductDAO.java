/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ProductDAO extends dao.Dao {

    private static final String INSERT_BOOK_SQL = "INSERT INTO demo.book" + " (img ,name, price,number) VALUES "
            + " (?,?,?,?);";
    private static final String SELECT_BOOK_BY_ID = "select img ,name, price,number from demo.book where id =?";
    private static final String SELECT_ALL_BOOK = "SELECT * FROM demo.book";
    private static final String DELETE_BOOK_SQL = "delete from demo.book where id = ?;";
   private static final String UPDATE_BOOK_SQL = "update demo.book set img = ?,name= ?, price =? ,number=?  where id = ?;";
    private static final String SELECT_SEARCH_BOOK = "SELECT * FROM demo.book WHERE name LIKE ? ";

    public ProductDAO() {
    }

    
    public boolean insertBook(Book b) {
        boolean check = false;
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK_SQL)) {
            preparedStatement.setString(1, b.getImg());
            preparedStatement.setString(2, b.getName());
            preparedStatement.setFloat(3, b.getPrice());
            preparedStatement.setInt(4, b.getNumber());
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return check;
    }

  
    public Book selectBook(int id) {
        Book book = null;
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String img = rs.getString("img");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                int number = rs.getInt("number");
                book = new Book(id, img, name, price, number);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return book;
    }

   
    public List<Book> selectAllBook() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOK);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String img = rs.getString("img");
                String name = rs.getString("name");
                Float price = rs.getFloat("price");
                int number = rs.getInt("number");
                books.add(new Book(id, img, name, price, number));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return books;
    }

    public boolean deleteBook(int id) {
        boolean check = false;
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_BOOK_SQL);) {
            statement.setInt(1, id);
            check = statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    public boolean updateBook(Book book) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK_SQL);) {
            statement.setString(1, book.getImg());
            statement.setString(2, book.getName());
            statement.setFloat(3, book.getPrice());
            statement.setInt(4, book.getNumber());
            statement.setInt(5, book.getId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowUpdated;
    }

  
    public List<Book> selectSearchBook(String book) {
        List<Book> books = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SEARCH_BOOK);) {
            String[] temp = book.split(" ");
            preparedStatement.setString(1, temp[0] + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String img = rs.getString("img");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                int number = rs.getInt("number");
                books.add(new Book(id, img, name, price, number));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return books;
    }

    private void printSQLException(SQLException e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
