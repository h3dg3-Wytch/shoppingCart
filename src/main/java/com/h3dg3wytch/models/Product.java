package com.h3dg3wytch.models;

import java.util.UUID;

/**
 * Created by h3dg3wytch on 12/6/16.
 */
public class Product {

    private String productId;
    private String productName;
    private double productPrice;
    private String imageUrl;
    private String productDescription;

    public Product(){

        this.productId = UUID.randomUUID().toString();

    }

    public Product(String productId, String productName,double productPrice,String imageUrl){
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.imageUrl = imageUrl;
    }

    public Product( String productName,double productPrice,String imageUrl){
        this.productId = UUID.randomUUID().toString();
        this.productName = productName;
        this.productPrice = productPrice;
        this.imageUrl = imageUrl;
    }


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
