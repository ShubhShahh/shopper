package com.sshop.shopper.entities;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class products {

    String productImage;
    String productName;
    float productPrice;
    String productDescription;
    @Id
    String productId;
    @Enumerated(EnumType.STRING)
    CATEGORY productCategory;
    @Enumerated(EnumType.STRING)
    STATUS productStatus;

    @OneToMany
    @JoinColumn(name = "productId", referencedColumnName = "productId")
    public List<Cart> cartsObj = new LinkedList<>();
    

    public products(String productImage, String productName, float productPrice, String productDescription, String productId, CATEGORY productCategory, STATUS productStatus) {
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productId = productId;
        this.productCategory = productCategory;
        this.productStatus = productStatus;
    }

    public products() {
    }

    public String getProductImage() {
        return this.productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return this.productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    public String getProductId() {
        return this.productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }


    public CATEGORY getProductCategory() {
        return this.productCategory;
    }

    public void setProductCategory(CATEGORY productCategory) {
        this.productCategory = productCategory;
    }

    public STATUS getProductStatus() {
        return this.productStatus;
    }

    public STATUS setProductStatus(STATUS productStatus) {
        return this.productStatus = productStatus;
        
    }

    @Override
    public String toString() {
        return "{" +
            " productImage='" + getProductImage() + "'" +
            ", productName='" + getProductName() + "'" +
            ", productPrice='" + getProductPrice() + "'" +
            ", productDescription='" + getProductDescription() + "'" +
            ", productId='" + getProductId() + "'" +
            ", productCategory='" + getProductCategory() + "'" +
            ", productStatus='" + getProductStatus() + "'" +
            "}";
    }

    

}
