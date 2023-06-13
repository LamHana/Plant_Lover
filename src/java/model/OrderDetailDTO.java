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
public class OrderDetailDTO {
    private int orderDetailHeaderID;
    private String date;
    private String status;
    private int orderHeaderID;

    public OrderDetailDTO() {
        this.orderDetailHeaderID = 0;
        this.date = null;
        this.status = null;
        this.orderHeaderID = 0;
    }

    public OrderDetailDTO(int orderDetailHeaderID, String date, String status, int orderHeaderID) {
        this.orderDetailHeaderID = orderDetailHeaderID;
        this.date = date;
        this.status = status;
        this.orderHeaderID = orderHeaderID;
    }

    public int getOrderDetailHeaderID() {
        return orderDetailHeaderID;
    }

    public void setOrderDetailHeaderID(int orderDetailHeaderID) {
        this.orderDetailHeaderID = orderDetailHeaderID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOrderHeaderID() {
        return orderHeaderID;
    }

    public void setOrderHeaderID(int orderHeaderID) {
        this.orderHeaderID = orderHeaderID;
    }
    
}
