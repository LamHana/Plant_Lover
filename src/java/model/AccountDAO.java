/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBUtils;

/**
 *
 * @author Hana
 */
public class AccountDAO {
    private static final String LOGIN = "SELECT accountID FROM Account " + "WHERE email=? AND password=?";
    private static final String USER = "SELECT * FROM UserTb " + "WHERE accountID=?";
    public UserDTO getUserByAccountID(int accountID) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(USER);
                ptm.setString(1, String.valueOf(accountID));
                rs = ptm.executeQuery();
                if (rs.next()) {
                    int userID = Integer.valueOf(rs.getString("userID"))  ;
                    String userName = rs.getString("userName");
                    String phoneNumber = rs.getString("phoneNumber");
                    String roleID = rs.getString("roleID");
                    String address = rs.getString("address");
                    user = new UserDTO(userID, userName, userName, roleID, address, accountID);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        
        return user;
    }
    
    public AccountDTO checkLogin(String email, String password) throws SQLException {
        AccountDTO userAccount = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
//           code 
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, email);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    int accountID = Integer.valueOf(rs.getString("accountID")) ;
                    userAccount = new AccountDTO(accountID, email, password);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return userAccount;
    }
}
