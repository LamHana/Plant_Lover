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

    private static final String PRODUCT = "EXEC GetProductList ?, ?, ?, ?";
    private static final String REMOVE = "UPDATE Product SET isDeleted=? WHERE productID=?";
    private static final String ADD = "INSERT INTO Product (ProductName, Price, CategoryID, Description, Quantity, isDeleted) VALUES (?, ?, ?, ?, ?, 0)";
    private static final String UPDATE = "UPDATE Product SET ProductName = ?,Price = ?,Quantity = ? WHERE ProductID = ?";
    private static final String TOTAL = "SELECT COUNT(*) FROM Product WHERE isDeleted != 1";

    public List<ProductDTO> getListProduct(String search, String category, int offset, int size) throws SQLException {
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
                ptm.setInt(3, offset);
                ptm.setInt(4, size);
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

    public Boolean addProduct(ProductDTO newProduct) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
//        ResultSet rs = null;
        try {
//           code 
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADD);
                ptm.setString(1, newProduct.getProductName());
                ptm.setDouble(2, newProduct.getPrice());
                ptm.setInt(3, newProduct.getCategoryID());
                ptm.setString(4, newProduct.getDescription());
                ptm.setInt(5, newProduct.getQuantity());
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

    public boolean update(ProductDTO newProduct) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
//        ResultSet rs = null;
        try {
//           code 
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, newProduct.getProductName());
                ptm.setDouble(2, newProduct.getPrice());
                ptm.setInt(3, newProduct.getQuantity());
                ptm.setInt(4, newProduct.getProductID());
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

    public int getTotalProduct() throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
//           code 
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(TOTAL);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    return rs.getInt(1);
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
        return 0;
    }

//    public static void main(String[] args) throws SQLException {
//        ProductDAO dao = new ProductDAO();
//        List<ProductDTO> list = dao.getListProduct(null, null, 2, 10);
//        for (ProductDTO productDTO : list) {
//            System.out.println(productDTO);
//        }
//    }
}
