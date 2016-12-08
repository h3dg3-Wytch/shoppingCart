package com.h3dg3wytch;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by h3dg3wytch on 12/7/16.
 */

@WebServlet(description = "Register Servlet", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

    public static final String HTML_START="<html><body>";
    public static final String HTML_END="</body></html>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print(HTML_START+ "<h1>Register</h1>" +HTML_END);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print(HTML_START);
        out.print("<p>" + req.getParameter("firstName")+ "</p>");
        out.print("<p>" + req.getParameter("lastName")+ "</p>");
        out.print("<p>" +req.getParameter("userName")+ "</p>");
        out.print("<p>" +req.getParameter("firstPassword")+ "</p>");
        out.print("<p>" +req.getParameter("secondPassword")+ "</p>");
        out.print(HTML_END);




    }
}
