package com.h3dg3wytch.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by h3dg3wytch on 12/7/16.
 */
public class AdminManager extends Manager {

    private static final String SELECT_SQL_QUERY = "SELECT * FROM admins";

    public ArrayList<String> admins;


    public AdminManager(String dbUrl, String dbUser, String dbpassword) throws SQLException, ClassNotFoundException {
        super(dbUrl, dbUser, dbpassword);
        admins = new ArrayList<>();
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
        Connection connection = null;
        Statement statement = null;
        try {
            connection = dbConnectionManager.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_SQL_QUERY);

            while (resultSet.next()){
                String userId = resultSet.getString("userId");
                admins.add(userId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;


    }
}
