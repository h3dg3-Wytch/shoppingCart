package com.h3dg3wytch.database;

import com.h3dg3wytch.models.Order;
import com.h3dg3wytch.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 * Created by h3dg3wytch on 12/7/16.
 */
public class OrderManager extends Manager
{
    private HashMap<Integer, Order> orders = new HashMap<>();

    public OrderManager(String dbUrl, String dbUser, String dbpassword) throws SQLException, ClassNotFoundException
    {
        super(dbUrl, dbUser, dbpassword);
        get();
    }


    @Override
    public boolean delete()
    {
        return false;
    }

    @Override
    public boolean insert()
    {
        return false;
    }

    @Override
    public boolean get()
    {

        Connection connection = null;
        Statement statement = null;
        try
        {
            connection = dbConnectionManager.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");

            while (resultSet.next())
            {

                int orderId = resultSet.getInt("orderId");
                String productId = resultSet.getString("productId");
                String userId = resultSet.getString("userId");


                Order order = new Order(orderId, productId, userId);
                orders.put(orderId, order);

            }
        }
        catch (SQLException e)
        {
            return false;
            //e.printStackTrace();
        }
        return true;
    }

    public HashMap getOrders()
    {
        return orders;
    }

    public boolean addOrder(Order order)
    {
        if (order != null)
        {
            try
            {
                Connection connection = dbConnectionManager.getConnection();
                Statement statement = connection.createStatement();

                String userId = order.getUserId();
                String productId = order.getProductId();

                String sql = "INSERT INTO orders (userId, productId) VALUES (" + "'" + userId+ "', '" + productId + "')";

                statement.executeUpdate(sql);

                orders.clear();
                get();
                return true;
            }
            catch (SQLException e)
            {
                e.printStackTrace();
                return false;
            }
        }
        else
        {
                return false;
        }
    }
}
