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
public class ProductDAO {
    private static final String PRODUCT = "EXEC GetProductList ?, ?";
    private static final String REMOVE = "UPDATE Product SET isDeleted=? WHERE productID=?";
    
    public List<ProductDTO> getListProduct(String search, String category) throws SQLException {
       List<ProductDTO> list = new ArrayList<>();
       Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
//           code 
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(PRODUCT);
                ptm.setString(1, search);
                ptm.setString(2, category);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("productID");
                    String productName = rs.getString("productName");
                    Double price = rs.getDouble("price");
                    int categoryID = rs.getInt("categoryID");
                    int quantity = rs.getInt("quantity");
                    String desc = rs.getString("description");
                    boolean isDeleted = rs.getBoolean("isDeleted");
                    list.add(new ProductDTO(productID, productName, desc, price, quantity, categoryID, isDeleted));
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

    public boolean removeProduct(String ProductID) throws SQLException {
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
                ptm.setString(2, ProductID);
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

//    public List<ProductDTO> getListProductBySearch(String search) throws SQLException {
//        List<ProductDTO> listProduct = new ArrayList<>();
//        Connection conn = null;
//        PreparedStatement ptm = null;
//        ResultSet rs = null;
//        try {
////           code 
//            conn = DBUtils.getConnection();
//            if (conn != null) {
//                ptm = conn.prepareStatement(SEARCH);
//                ptm.setString(1, "%" + search + "%");
//                rs = ptm.executeQuery();
//                while (rs.next()) {
//                    int productID = rs.getInt("productID");
//                    String productName = rs.getString("productName");
//                    Double price = rs.getDouble("price");
//                    int categoryID = rs.getInt("categoryID");
//                    int quantity = rs.getInt("quantity");
//                    String desc = rs.getString("description");
//                    boolean isDeleted = rs.getBoolean("isDeleted");
//                    listProduct.add(new ProductDTO(productID, productName, desc, price, quantity, categoryID, isDeleted));
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (ptm != null) {
//                ptm.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//
//        }
//        return listProduct;
//    }
    
}
