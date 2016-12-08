package com.h3dg3wytch.database;

import com.h3dg3wytch.models.User;

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

    public void addUser(User user) {
        admins.add(user.getUserId());
        if (user != null) {
            try {
                Connection connection = dbConnectionManager.getConnection();
                Statement statement = connection.createStatement();
                //String sql = "INSERT INTO user (firstName, lastName, userId, userName, password) VALUES ("+ user.getUserName()+", "+user.getLastName()+"," +user.getUserId()+", "+user.getUserName()+", "+ user.getPassword()+")";
                String sql = "INSERT INTO admins VALUES ('" + user.getUserId() + "')";

                statement.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void addUser(String userId) {
        admins.add(userId);
        if (userId != null) {
            try {
                Connection connection = dbConnectionManager.getConnection();
                Statement statement = connection.createStatement();
                //String sql = "INSERT INTO user (firstName, lastName, userId, userName, password) VALUES ("+ user.getUserName()+", "+user.getLastName()+"," +user.getUserId()+", "+user.getUserName()+", "+ user.getPassword()+")";
                String sql = "INSERT INTO admins (userId) VALUES ('" + userId + "')";
                statement.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeUserAsAdmin(String userId){
        admins.remove(userId);
            try {
                Connection connection = dbConnectionManager.getConnection();
                Statement statement = connection.createStatement();
                //String sql = "INSERT INTO user (firstName, lastName, userId, userName, password) VALUES ("+ user.getUserName()+", "+user.getLastName()+"," +user.getUserId()+", "+user.getUserName()+", "+ user.getPassword()+")";
                String sql = "DELETE FROM admins WHERE userId = '" + userId +"'";
                statement.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public void removeUserAsAdmin(User user){

        admins.remove(user.getUserId());
        try {
            Connection connection = dbConnectionManager.getConnection();
            Statement statement = connection.createStatement();
            //String sql = "INSERT INTO user (firstName, lastName, userId, userName, password) VALUES ("+ user.getUserName()+", "+user.getLastName()+"," +user.getUserId()+", "+user.getUserName()+", "+ user.getPassword()+")";
            String sql = "DELETE FROM admins WHERE userdId = '" + user.getUserId() +"')";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<String> getAdmins() {
        return admins;
    }


}
