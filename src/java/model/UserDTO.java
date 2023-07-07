/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Hana
 */
public class UserDTO {
    private int userID;
    private String userName;
    private String phoneNumber;
    private String roleID;
    private String address;
    private int accountID;
    private boolean isDeleted;

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "userID=" + userID + ", userName=" + userName + ", phoneNumber=" + phoneNumber + ", roleID=" + roleID + ", address=" + address + ", accountID=" + accountID + '}';
    }
    
    public UserDTO() {
        this.userID = 0;
        this.userName = "";
        this.phoneNumber = "";
        this.roleID = "";
        this.address = "";
        this.accountID = 0;
        this.isDeleted = false;
    }
    public UserDTO(String userName, String phoneNumber, String roleID, String address) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.roleID = roleID;
        this.address = address;
        this.accountID = 0;
        this.isDeleted = false;
    }
    
    public UserDTO(String userName, String phoneNumber, String roleID, String address, int accountID, boolean isDeleted) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.roleID = roleID;
        this.address = address;
        this.accountID = accountID;
        this.isDeleted = isDeleted;
    }
    
    public UserDTO(int userID, String userName, String phoneNumber, String roleID, String address, int accountID, boolean isDeleted) {
        this.userID = userID;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.roleID = roleID;
        this.address = address;
        this.accountID = accountID;
        this.isDeleted = isDeleted;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
    
    
    
}
