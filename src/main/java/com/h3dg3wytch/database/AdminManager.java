package com.h3dg3wytch.database;

import java.sql.SQLException;

/**
 * Created by h3dg3wytch on 12/7/16.
 */
public class AdminManager extends Manager {

    public AdminManager(String dbUrl, String dbUser, String dbpassword) throws SQLException, ClassNotFoundException {
        super(dbUrl, dbUser, dbpassword);
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
        return false;
    }
}
