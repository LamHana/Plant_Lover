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
public class AccountDTO {
    private int accountID;
    private String Email;
    private String Password;

    public AccountDTO() {
        this.accountID = 0;
        this.Email = "";
        this.Password = "";
    }

    public AccountDTO(int accountID, String Email, String Password) {
        this.accountID = accountID;
        this.Email = Email;
        this.Password = Password;
    }

    
    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    
    
    
}
