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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author ADMIN
 */
public class AccountDAO extends Dao{

    private static final String SELECT_USER = "SELECT * FROM demo.account WHERE username=? and password=?";

    public AccountDAO() {
    }

    /**
     *
     * @param account
     * @return
     * 
     */
    public Account checkUser(Account account){
        Account a = new  Account();
        try (Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(SELECT_USER);) {
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = new Account(rs.getInt("id"), rs.getString("username"), rs.getString("password")); 
                return a;
            }            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null
                ;
    }
}
