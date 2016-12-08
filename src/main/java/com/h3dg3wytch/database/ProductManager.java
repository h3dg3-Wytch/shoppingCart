package com.h3dg3wytch.database;

import com.h3dg3wytch.models.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by h3dg3wytch on 12/7/16.
 */
public class ProductManager extends Manager {

    private ArrayList<Product> products;

    public ProductManager(String dbUrl, String dbUser, String dbpassword) throws SQLException, ClassNotFoundException {
        super(dbUrl, dbUser, dbpassword);
        get();
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public boolean insert() {
        return false;
    }

    @Override
    public boolean get() {

        Connection connection =null;

        Statement statement = null;
        try{
            connection = dbConnectionManager.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM product");

            while(resultSet.next()){

                String productId = resultSet.getString("productId");
                String productName = resultSet.getString("productName");
                double productPrice = resultSet.getBigDecimal("productPrice").doubleValue();
                String productImageURL = resultSet.getString("productImageURL");
                String productDescription = resultSet.getString("productDescription");

                Product product = new Product(productId, productName, productPrice, productImageURL, productDescription);
                products.add(product);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
