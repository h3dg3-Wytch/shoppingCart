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

    private HashMap<Integer, User> users;

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

                int userId = resultSet.getInt("userId");
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

    public HashMap<Integer, User> getUsers() {
        return users;
    }

    public void addUser(User user){
        if(user != null) {
            try {
                Connection connection = connectionManager.getConnection();
                Statement statement = connection.createStatement();
                String sql = "INSERT INTO user (firstName, lastName, userName, password) VALUES (" + user.getFirstName() + "," + user.getLastName() + "," + user.getUserName() + "," + user.getPassword() + ")";
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
    public User findUserInDatabase(){
        return null;

    }

    public User findUserByNameAndPassword(String username, String password){
        for(User user: users.values()){
            if(user.getUserName().equals(username) && user.getPassword().equals(password))
                return user;
        }
        return null;
    }

    private void deleteUser(){

    }

    //todo Makes sql user admin table
    private void makeUserAdmin(){

    }


    private void removeUsersAdminStatus(){

    }

    public void destoryConnection(){
        try {
            connectionManager.getConnection().close();
            connectionManager = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
