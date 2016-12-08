package com.h3dg3wytch.database;

import java.sql.SQLException;

/**
 * Created by h3dg3wytch on 12/7/16.
 */
public abstract class Manager {

    protected DBConnectionManager dbConnectionManager;

    public Manager(String dbUrl, String dbUser, String dbpassword) throws SQLException, ClassNotFoundException {
        dbConnectionManager = new DBConnectionManager(dbUrl, dbUser, dbpassword);
    }

    public abstract boolean delete();
    public abstract boolean insert();
    public abstract boolean get();

}
