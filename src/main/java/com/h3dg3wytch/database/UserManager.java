package com.h3dg3wytch.database;

import com.h3dg3wytch.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 * Created by h3dg3wytch on 12/5/16.
 */
public class UserManager {

    private DBConnectionManager connectionManager;

    private HashMap<String, User> users;

    public UserManager(){
        users = new HashMap<>();
    }

    public UserManager(String dbUrl, String dbUser, String dbPassword) throws SQLException, ClassNotFoundException {

        connectionManager = new DBConnectionManager(dbUrl, dbUser, dbPassword);
        users = new HashMap<>();
        setUpUsers();

    }

    private void setUpUsers(){

        Connection connection = null;
        Statement statement = null;
        try{
            connection = connectionManager.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");

            while(resultSet.next()){

                String userId = resultSet.getString("userId");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String userName = resultSet.getString("userName");
                String password = resultSet.getString("password");

                User user = new User(userId, firstName, lastName, userName, password);
                users.put(userId, user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public void addUser(User user){
        users.put(user.getUserId(), user);
        if(user != null) {
            try {
                Connection connection = connectionManager.getConnection();
                Statement statement = connection.createStatement();
                //String sql = "INSERT INTO user (firstName, lastName, userId, userName, password) VALUES ("+ user.getUserName()+", "+user.getLastName()+"," +user.getUserId()+", "+user.getUserName()+", "+ user.getPassword()+")";
                String sql = "INSERT INTO user VALUES (" + "'" + user.getFirstName()+ "', '" + user.getLastName() + "','" +user.getUserId() + "','" + user.getUserName() +  "','" + user.getPassword()+ " ')";

                    statement.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public User findUser(int userId){
        return users.get(userId);
    }

    //todo return specific user in database
    public User findUserByNameAndPassword(String username, String password){
        for(User user: users.values()){
            if(user.getUserName().equals(username) && user.getPassword().equals(password))
                return user;
        }
        return null;
    }

    public void deleteUser(User user){
        users.remove(user.getUserId());
        try {
            Connection connection = connectionManager.getConnection();
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM user WHERE userId =  '" + user.getUserId() + "'";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteUser(String userId){
        users.remove(userId);
        try {
            Connection connection = connectionManager.getConnection();
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM user WHERE userId =  '" + userId+ "';";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void destoryConnection(){
        try {
            connectionManager.getConnection().close();
            connectionManager = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DBConnectionManager getConnectionManager() {
        return connectionManager;
    }

    public void setConnectionManager(DBConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }
}
