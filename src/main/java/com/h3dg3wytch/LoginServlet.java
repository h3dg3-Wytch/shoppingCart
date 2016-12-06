package com.h3dg3wytch;

import com.h3dg3wytch.database.DBConnectionManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import com.mysql.cj.jdbc.Driver;

/**
 * Created by h3dg3wytch on 12/3/16.
 */
@WebServlet(description = "Login Servlet", urlPatterns = {"/LoginServlet"}, initParams = {@WebInitParam(name = "user", value = "    "), @WebInitParam(name ="password", value = "")})
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public static final String HTML_START="<html><body>";
    public static final String HTML_END="</body></html>";

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost/shoppingCart";

    //Database creditionals
    static final String USER = "developer";
    static final String PASSWORD ="password";

    private DBConnectionManager connectionManager;


    public void init() throws ServletException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {

        Connection connection = null;
        Statement statement = null;

        PrintWriter out = response.getWriter();
        out.print(HTML_START);
        out.print("<h1>Login</h1>");
        try{
            //Step 2: register JDBC driver
            try {
                Class.forName(JDBC_DRIVER).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            //Step 3 open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            if(connection == null){
                out.print("<p>error null</p>");
            }

            //Exectue query
            statement = connection.createStatement();
            String sql = "SELECT * FROM user";
            ResultSet resultSet = statement.executeQuery(sql);

            //Extract data from result set
            while (resultSet.next()){
                String first = resultSet.getString("firstName");
                String last = resultSet.getString("lastName");

                out.print("<p>First: " + first +"</p>");
                out.print("<p>Last: " + last +"</p>");

            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.print("<p>error class2</p>");
        } catch (SQLException e) {
            e.printStackTrace();
            out.print("<p>error sql</p>");
        }finally {

            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        out.print(HTML_END);
//
//        Connection connection = null;
//        Statement statement = null;
//
//
//        try {
//
//            connectionManager = new DBConnectionManager(getServletContext().getInitParameter("dbURL"),
//                    getServletContext().getInitParameter("dbUser"),
//                    getServletContext().getInitParameter("dbUserPwd"));
//            connection = connectionManager.getConnection();
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        PrintWriter out = response.getWriter();
//
//        out.print(HTML_START);
//        out.print("<h1>Login Page</h1>");
//        out.print("<p>" +  getServletContext().getInitParameter("dbURL") + " " + getServletContext().getInitParameter("dbUser") + " " + getServletContext().getInitParameter("dbUserPwd") + "</p>" );
//        if(connection == null){
//            out.print("<p>ERROR</p>");
//        }
//
//        try{
//            statement = connection.createStatement();
//            String sql = "SELECT * FROM user";
//            ResultSet resultSet = statement.executeQuery(sql);
//
//            while(resultSet.next()){
//
//                String first = resultSet.getString("firstName");
////                String last = resultSet.getString("lastName");
////                String userName = resultSet.getString("userName");
////                String password = resultSet.getString("password");
//
//                out.println("<p> First: " + first + "</p>");
//            }
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//            out.println("<p>Error</p>");
//        }
//
//        out.print(HTML_END);


    }



}
