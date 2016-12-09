package com.h3dg3wytch;

import com.h3dg3wytch.database.AdminManager;
import com.h3dg3wytch.database.UserManager;
import com.h3dg3wytch.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by h3dg3wytch on 12/8/16.
 */


@WebServlet(description = "Admin Page", urlPatterns = {"/Admin"})
public class Admin extends HttpServlet {

    public static final String HTML_START="<html><body>";
    public static final String HTML_END="</body></html>";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserManager userManager = null;
        AdminManager adminManager = null;
        try {
            userManager = new UserManager(getServletContext().getInitParameter("dbURL"),
                    getServletContext().getInitParameter("dbUser"),
                    getServletContext().getInitParameter("dbUserPwd"));
            adminManager = new AdminManager(getServletContext().getInitParameter("dbURL"),
                    getServletContext().getInitParameter("dbUser"),
                    getServletContext().getInitParameter("dbUserPwd"));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String userId = req.getParameter("user");
        User user = userManager.findUser(userId);
        HttpSession session = req.getSession();

        session.setAttribute("doubleAdminError", "false");

        if(req.getParameter("delete") != null){
            userManager.deleteUser(user);
            resp.sendRedirect("admin.jsp");

        }else if(req.getParameter("addAdmin") != null){
            if(!adminManager.getAdmins().contains(user.getUserId())) {
                adminManager.addUser(user.getUserId());
                resp.sendRedirect("admin.jsp");
            }else{
                session.setAttribute("doubleAdminError", "true");
                resp.sendRedirect("admin.jsp");
            }

        }else if(req.getParameter("removeAdmin") != null){
            adminManager.removeUserAsAdmin(user.getUserId());
            resp.sendRedirect("admin.jsp");
        }

        try {
            userManager.getConnectionManager().getConnection().close();
            adminManager.getDbConnectionManager().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}


