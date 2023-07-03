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
public class ProductDTO {
    private int productID;
    private String productName;
    private String description;
    private double price;
    private int quantity;
    private int categoryID;
    private boolean isDeleted;
    private String image;
    
    public ProductDTO() {
        this.productID = 0;
        this.productName = "";
        this.description = "";
        this.price = 0;
        this.quantity = 0;
        this.categoryID = 0;
        this.isDeleted = false;
        this.image = null;
    }
    
    public ProductDTO(int productID, String productName, String description, double price, int quantity, int categoryID, boolean isDeleted) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.categoryID = categoryID;
        this.isDeleted = isDeleted;
        this.image = null;
    }
    
    public ProductDTO(int productID, String productName, String description, double price, int quantity, int categoryID, boolean isDeleted, String image) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.categoryID = categoryID;
        this.isDeleted = isDeleted;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String imageLink) {
        this.image = image;
    }


    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

   
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "productID=" + productID + ", productName=" + productName + ", description=" + description + ", price=" + price + ", quantity=" + quantity + ", categoryID=" + categoryID + ", isDeleted=" + isDeleted + ", image=" + image + '}';
    }

    

    
    
}
