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
public class OrderHeaderDTO {
    private int orderHeaderID;
    private String date;
    private String status;
    private int userID;

    public OrderHeaderDTO() {
        this.orderHeaderID = 0;
        this.date = null;
        this.status = null;
        this.userID = 0;
    }

    public OrderHeaderDTO(int orderHeaderID, String date, String status, int userID) {
        this.orderHeaderID = orderHeaderID;
        this.date = date;
        this.status = status;
        this.userID = userID;
    }
    
    
}
