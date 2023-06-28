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
public class UserError {
    private String emailError;
    private String fullNameError;
    private String phoneNumberError;
    private String addressError;
    private String roleIDError;
    private String passwordError;
    private String confirmError;
    private String error;

    public UserError() {
         this.emailError = "";
        this.fullNameError = "";
        this.phoneNumberError = "";
        this.addressError = "";
        this.roleIDError = "";
        this.passwordError = "";
        this.confirmError = "";
        this.error = "";
    }

 
    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getFullNameError() {
        return fullNameError;
    }

    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
    }

    public String getPhoneNumberError() {
        return phoneNumberError;
    }

    public void setPhoneNumberError(String phoneNumberError) {
        this.phoneNumberError = phoneNumberError;
    }

    public String getAddressError() {
        return addressError;
    }

    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }

    public String getRoleIDError() {
        return roleIDError;
    }

    public void setRoleIDError(String roleIDError) {
        this.roleIDError = roleIDError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getConfirmError() {
        return confirmError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    
}
