/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Book;
import model.Supplier;

/**
 *
 * @author ADMIN
 */
public class SupplierDAO extends Dao {

    private static final String SELECT_ALL_SUPPLIER = "SELECT * FROM demo.supplier";
    private static final String INSERT_SUPPLIER_SQL = "INSERT INTO demo.supplier" + " (name,address,phone) VALUES "
            + " (?,?,?);";
    private static final String SELECT_SUPPLIER_BY_ID = "select name,address,phone from demo.supplier where id =?";
    public SupplierDAO() {
    }

    public List<Supplier> selectAllSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SUPPLIER);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                suppliers.add(new Supplier(id, name, address, phone));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return suppliers;
    }

    public boolean insertSupplier(Supplier supplier) {
        boolean check = false;
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SUPPLIER_SQL)) {
            preparedStatement.setString(1, supplier.getName());
            preparedStatement.setString(2, supplier.getAddress());
            preparedStatement.setString(3, supplier.getPhone());
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return check;
    }

    public Supplier selectSupplier(int id) {
        Supplier supplier = null;
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SUPPLIER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String address = rs.getString("address");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                supplier = new Supplier(id,name, address, phone);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return supplier;
    }

    private void printSQLException(SQLException e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
