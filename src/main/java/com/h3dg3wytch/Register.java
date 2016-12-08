package com.h3dg3wytch;

import com.h3dg3wytch.database.UserManager;
import com.h3dg3wytch.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by h3dg3wytch on 12/7/16.
 */

@WebServlet(description = "Register Servlet", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

    public static final String HTML_START="<html><body>";
    public static final String HTML_END="</body></html>";

    private UserManager userManager;

    public void init() throws ServletException {
     try {
            userManager = new UserManager(getServletContext().getInitParameter("dbURL"),
                    getServletContext().getInitParameter("dbUser"),
                    getServletContext().getInitParameter("dbUserPwd"));

            getServletContext().setAttribute("userManager", userManager.getConnectionManager().getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.print(HTML_START+ "<h1>Register</h1>" +HTML_END);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        if (req.getParameter("firstPassword").equals(req.getParameter("secondPassword"))) {
            User user = new User(req.getParameter("firstName"), req.getParameter("lastName"), req.getParameter("userName"), req.getParameter("firstPassword"));
            userManager.addUser(user);
            createSession(user, req, resp);
            resp.sendRedirect("main.jsp");
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/register.jsp");
            out.println("<font color=red>Passwords don't match!</font>");
            rd.include(req, resp);

        }
    }

    public void createSession(User user, HttpServletRequest req, HttpServletResponse resp ){
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        //set session to expire in 30 minutes
        session.setMaxInactiveInterval(30 * 60);
        Cookie userCookie = new Cookie("user", user.getFirstName());
        userCookie.setMaxAge(30 * 60);
        resp.addCookie(userCookie);
    }
}
