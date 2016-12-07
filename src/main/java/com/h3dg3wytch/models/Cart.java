package com.h3dg3wytch.models;

import java.util.ArrayList;

/**
 * Created by h3dg3wytch on 12/6/16.
 */
public class Cart {

    private ArrayList<Product> products;

    public Cart(){
        this.products = new ArrayList<>();
    }

    public void addToCart(Product product){
        products.add(product);
    }

    public Product findInCart(Product product){
        for(Product productInCart : products){
            if(product.getProductId().equals(productInCart.getProductId()))
                return productInCart;
        }
        return null;
    }
    public Product findInCart(String productId){

        for(Product productInCart : products){
            if(productId.equals(productInCart.getProductId()))
                return productInCart;
        }
        return null;
    }
}
