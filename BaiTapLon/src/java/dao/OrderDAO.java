/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author ADMIN
 */
import model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Book;
import model.Supplier;

public class OrderDAO extends Dao {

    private static final String INSERT_ORDER_SQL = "INSERT INTO demo.order" + " (idBook,idSupplier, price,number,total) VALUES "
            + " (?,?,?,?,?);";
    private static final String SELECT_ALL_ORDER = "SELECT * FROM demo.order";
    private final ProductDAO bdao = new ProductDAO();
    private final SupplierDAO sdao = new SupplierDAO();
    private static final String SELECT_ORDER_BY_ID = "select idBook,idSupplier , price,number,total from demo.order where id =?";

    public List<Order> selectAllOder() {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDER);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int idBook = rs.getInt("idBook");
                int idSupplier = rs.getInt("idSupplier");
                float price = rs.getFloat("price");
                float total = rs.getFloat("total");
                int number = rs.getInt("number");
                Book book = bdao.selectBook(idBook);
                Supplier supplier = sdao.selectSupplier(idSupplier);
                orders.add(new Order(id, book, supplier, price, number, total));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return orders;
    }

    public boolean insertOrder(Order o) {
        boolean check = false;
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_SQL)) {
            preparedStatement.setInt(1, o.getBook().getId());
            preparedStatement.setInt(2, o.getSupplier().getId());
            preparedStatement.setFloat(3, o.getPrice());
            preparedStatement.setInt(4, o.getNumber());
            preparedStatement.setFloat(5, o.getTotal());
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return check;
    }

    public Order selecOrder(int id) {
        Order order = null;
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idBook = rs.getInt("idBook");
                int idSupplier = rs.getInt("idSupplier");
                float price = rs.getFloat("price");
                float total = rs.getFloat("total");
                int number = rs.getInt("number");
                Book book = bdao.selectBook(idBook);
                Supplier supplier = sdao.selectSupplier(idSupplier);
                order = new Order(id, book, supplier, price, number, total);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return order;
    }

    private void printSQLException(SQLException e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
