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
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import utils.DBUtils;

/**
 *
 * @author Hana
 */
public class CartDAO {

    private static final String CHECK_QUANTITY = "SELECT Quantity FROM Product WHERE ProductID=?";
    private static final String INSERT_ORDER = "INSERT INTO OrderHeader(Date, Status, UserID) VALUES (?,?,?)";
    private static final String INSERT_ORDERDETAIL = "INSERT INTO OrderDetail(OrderHeaderID, ProductID, Quantity, Price) VALUES((SELECT MAX(OrderHeaderID) FROM OrderHeader),?,?,?)";

    public Map<Integer, String> checkQuantity(Cart cart) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        String message = "";
        Map<Integer, String> listMessage = new HashMap<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                for (ProductDTO product : cart.getCart().values()) {
                    ptm = conn.prepareStatement(CHECK_QUANTITY);
                    ptm.setString(1, String.valueOf(product.getProductID()));
                    rs = ptm.executeQuery();
                    while (rs.next()) {
                        int quantity = rs.getInt("quantity");
                        System.out.println(quantity);
                        if (product.getQuantity() > quantity) {
                            message = product.getProductName() + " only have " + quantity + " left.";
                            listMessage.put(product.getProductID(), message);
                        }
                    }
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

        return listMessage;
    }

    public boolean insertOrder(Cart cart, int userID) throws SQLException {
         boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        LocalDate currentDate = LocalDate.now();
//        ResultSet rs = null;
        try {
//           code 
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT_ORDER, Statement.RETURN_GENERATED_KEYS);
                ptm.setString(1, currentDate.toString());
                ptm.setString(2, "true");
                ptm.setString(3, String.valueOf(userID));
//                int affectedRows = ptm.executeUpdate();
                check = ptm.executeUpdate() > 0 ? true : false;
//                if (affectedRows > 0) {
//                    rs = ptm.getGeneratedKeys();
//                    while (rs.next()) {
//                        generatedUserID = rs.getInt(1);
//                    }
//                }
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

    public boolean insertOrderDetail(Cart cart) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
//           code 
            conn = DBUtils.getConnection();
            if (conn != null) {
                for (ProductDTO product : cart.getCart().values()) {
                    ptm = conn.prepareStatement(INSERT_ORDERDETAIL);
                    ptm.setString(1, String.valueOf(product.getProductID()));
                    ptm.setString(2, String.valueOf(product.getQuantity()));
                    ptm.setString(3, String.valueOf(product.getPrice()));
                    check = ptm.executeUpdate() > 0 ? true : false;
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
            return check;
    }

}
