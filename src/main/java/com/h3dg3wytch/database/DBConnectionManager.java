package com.h3dg3wytch.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by h3dg3wytch on 12/3/16.
 */
public class DBConnectionManager {

    private Connection connection;

    public DBConnectionManager(String dbURL, String user, String pwd) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        this.connection = DriverManager.getConnection(dbURL, user, pwd);
        if(this.connection == null){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("NULL");

            }
        }
    }
    public Connection getConnection(){
        return this.connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
