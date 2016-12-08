package com.h3dg3wytch.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order
{

    private String orderId, productId, userId;

    public Order(String orderId, String productId, String userId)
    {
        this.orderId = orderId;
        this.productId = productId;
        this.userId = userId;

    }

    public String getOrderId()
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
}