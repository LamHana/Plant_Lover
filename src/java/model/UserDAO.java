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
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author Hana
 */
public class UserDAO {
    private static final String USER = "EXEC GetUserList ?, ?, ?";
    private static final String UPDATE = "UPDATE UserTb SET userName=?, roleID=?, phoneNumber=?, address=? WHERE userID=?";
    private static final String REMOVE = "UPDATE UserTb SET isDeleted=? WHERE userID=?";
    
    public List<UserDTO> getListUser(String search, int offset, int size) throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
//           code 
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(USER);
                ptm.setString(1, search);
                ptm.setInt(2, offset);
                ptm.setInt(3, size);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int userID = rs.getInt("userID");
                    String userName = rs.getString("userName");
                    String phoneNumber = rs.getString("phoneNumber");
                    String roleID = rs.getString("roleID");
                    String address = rs.getString("address");
                    boolean isDeleted = rs.getBoolean("isDeleted");
                    list.add(new UserDTO(userID, userName, phoneNumber, roleID, address, userID, isDeleted));
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
        return list;
    }

    public boolean update(UserDTO user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
//        ResultSet rs = null;
        try {
//           code 
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, user.getUserName());
                ptm.setString(2, user.getRoleID());
                ptm.setString(3, user.getPhoneNumber());
                ptm.setString(4, user.getAddress());
                ptm.setInt(5, user.getUserID());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            if (rs != null) {
//                rs.close();
//            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
    }
            return check;
    }

    public boolean delete(int userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
//        ResultSet rs = null;
        try {
//           code 
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(REMOVE);
                ptm.setString(1, "True");
                ptm.setInt(2, userID);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            if (rs != null) {
//                rs.close();
//            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return check;
    }
}
