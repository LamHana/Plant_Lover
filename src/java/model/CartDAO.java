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
import java.util.HashMap;
import java.util.Map;
import utils.DBUtils;

/**
 *
 * @author Hana
 */
public class CartDAO {

    private static final String CHECK_QUANTITY = "SELECT Quantity FROM Product WHERE ProductID=?";

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

}
