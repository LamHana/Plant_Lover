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
import utils.DBUtils;

/**
 *
 * @author Hana
 */
public class AccountDAO {

    private static final String LOGIN = "SELECT * FROM Account " + "WHERE email=? AND password=?";
    private static final String ISEXITEMAIL = "SELECT * FROM Account " + "WHERE email=?";
    private static final String USER = "SELECT * FROM UserTb " + "WHERE accountID=?";
    private static final String INSERT_ACCOUNT = "INSERT INTO Account(email,password) VALUES(?,?)";
    private static final String INSERT_USER = "INSERT INTO UserTb (UserName, PhoneNumber, RoleID, Address, AccountID, isDeleted) VALUES(?,?,?,?,(SELECT MAX(AccountID) FROM Account),?)";
    private static final String GET_NEW_ACCOUNTID = "SELECT TOP (1) [AccountID] FROM Account ORDER BY accountID desc";
    private static final String CHECK_DUPLICATE = "SELECT email FROM Account WHERE email=?";

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
                    int userID = rs.getInt("userID");
                    String userName = rs.getString("userName");
                    String phoneNumber = rs.getString("phoneNumber");
                    String roleID = rs.getString("roleID");
                    String address = rs.getString("address");
                    boolean isDeleted = rs.getBoolean("isDeleted");
                    user = new UserDTO(userID, userName, phoneNumber, roleID, address, accountID, isDeleted);
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
                    int accountID = Integer.valueOf(rs.getString("accountID"));
                    boolean isDeleted = rs.getBoolean("isDeleted");
                    if (!isDeleted) {
                        userAccount = new AccountDTO(accountID, email);
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
        return userAccount;
    }

    public AccountDTO checkIsExist(String email) throws SQLException {
        AccountDTO userAccount = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
//           code 
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ISEXITEMAIL);
                ptm.setString(1, email);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    int accountID = Integer.valueOf(rs.getString("accountID"));
                    boolean isDeleted = rs.getBoolean("isDeleted");
                    if (!isDeleted) {
                        userAccount = new AccountDTO(accountID, email);
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
        return userAccount;
    }

    public boolean checkDuplicate(String email) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
//           code 
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, email);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    boolean isDeleted = rs.getBoolean("isDeleted");
                    if (!isDeleted) {
                        check = true;
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
        return check;
    }

    public boolean insertAccout(AccountDTO userAccount) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
//        ResultSet rs = null;
        try {
//           code 
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT_ACCOUNT);
                ptm.setString(1, userAccount.getEmail());
                ptm.setString(2, userAccount.getPassword());
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

    public boolean insertUser(UserDTO user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
//        ResultSet rs = null;
        try {
//           code 
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT_USER);
                ptm.setString(1, user.getUserName());
                ptm.setString(2, user.getPhoneNumber());
                ptm.setString(3, user.getRoleID());
                ptm.setString(4, user.getAddress());
                ptm.setBoolean(5, false);
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

    public int getNewAccountID() throws SQLException {
        int accountID = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_NEW_ACCOUNTID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    accountID = rs.getInt("accountID");
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

        return accountID;
    }

}
