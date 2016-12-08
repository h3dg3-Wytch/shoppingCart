package com.h3dg3wytch;

import com.h3dg3wytch.database.AdminManager;
import com.h3dg3wytch.database.DBConnectionManager;
import com.h3dg3wytch.database.UserManager;
import com.h3dg3wytch.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by h3dg3wytch on 12/3/16.
 */
@WebServlet(description = "Login Servlet", urlPatterns = {"/LoginServlet"}, initParams = {@WebInitParam(name = "user", value = "    "), @WebInitParam(name ="password", value = "")})
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public static final String HTML_START="<html><body>";
    public static final String HTML_END="</body></html>";

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost/shoppingCart";


    private DBConnectionManager connectionManager;
    private UserManager userManager;
    private ArrayList<String> admins;



    public void init() throws ServletException {

        try {
            userManager = new UserManager(getServletContext().getInitParameter("dbURL"),
                    getServletContext().getInitParameter("dbUser"),
                    getServletContext().getInitParameter("dbUserPwd"));
            AdminManager adminManager = new AdminManager(getServletContext().getInitParameter("dbURL"),
                    getServletContext().getInitParameter("dbUser"),
                    getServletContext().getInitParameter("dbUserPwd"));
            admins = adminManager.getAdmins();
            adminManager = null;


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {

        PrintWriter out = response.getWriter();
        out.print(HTML_START);
        Connection connection = null;
        Statement statement = null;

        try {
            connectionManager = new DBConnectionManager(getServletContext().getInitParameter("dbURL"),
                    getServletContext().getInitParameter("dbUser"),
                    getServletContext().getInitParameter("dbUserPwd"));
            connection = connectionManager.getConnection();
            if(connection == null)
                out.print("<p>Null Error</p>");

            statement = connection.createStatement();
            String sql = "SELECT * FROM user";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                String first = resultSet.getString("firstName");
                String last = resultSet.getString("lastName");
                String userName = resultSet.getString("userName");
                String password = resultSet.getString("password");
                out.println("<p> First: " + first + "</p>");
                out.println("<p> Last: " + last + "</p>");
                out.println("<p> UserName: " + userName + "</p>");
                out.println("<p> password: " + password + "</p>");
            }


        } catch (ClassNotFoundException e) {
            out.print("<p>Class Error</p>");
            e.printStackTrace();
        } catch (SQLException e) {
            out.print("<p>SQL Error</p>");
            out.print("<p>" + e.getMessage() + " " + e.getSQLState() + "</p>");
        }finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try{
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        out.print(HTML_END);

        //Make sure to close the

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("user");
        String password = req.getParameter("password");

        User user = userManager.findUserByNameAndPassword(userName, password);
        if(user != null){
            //resp.sendRedirect("main.jsp");

           createSession(user, req, resp);

            resp.sendRedirect("main.jsp");

        }else{
           resp.sendRedirect("login.jsp");
        }
    }


    public void createSession(User user, HttpServletRequest req, HttpServletResponse resp ){
        HttpSession session = req.getSession();
        session.setAttribute("user", user);

        if(admins.contains(user.getUserId())) {
            System.out.print("TRUE");
            session.setAttribute("admin", "true");
        }else {
            log("FALSE");
            session.setAttribute("admin", "false");
        }
        //set session to expire in 30 minutes
        session.setMaxInactiveInterval(30 * 60);

        Cookie userCookie = new Cookie("user", user.getFirstName());
        userCookie.setMaxAge(30 * 60);
        resp.addCookie(userCookie);

    }
}
