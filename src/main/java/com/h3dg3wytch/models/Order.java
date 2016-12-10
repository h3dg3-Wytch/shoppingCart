package com.h3dg3wytch.models;

public class Order
{

    private String productId, userId;
    private int orderId;


    public Order(String productId, String userId)
    {
        this.productId = productId;
        this.userId = userId;
    }

    public Order(int orderId, String productId, String userId)
    {
        this.orderId = orderId;
        this.productId = productId;
        this.userId = userId;
    }

    public int getOrderId()
    {
        return orderId;
    }

    public String getProductId()
    {
        return productId;
    }

    public String getUserId()
    {
        return userId;
    }

    @Override
    public String toString() {
        return "OrderId: " + orderId + " UserId: " + userId + " ProductId: " + productId;
    }
}