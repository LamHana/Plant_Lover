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
public class CategoryDAO {
    private static final String CATEGORY = "SELECT * FROM Category";
    
  
    public Map<Integer, String> getAllCategory() throws SQLException {
        Map<Integer, String> list = new HashMap<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
//           code 
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CATEGORY);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int categoryID = rs.getInt("categoryID");
                    String categoryName = rs.getString("name");
                    list.put(categoryID, categoryName);
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
}
