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
 * Created by h3dg3wytch on 12/8/16.
 */


@WebServlet(description = "Admin Page", urlPatterns = {"/Admin"})
public class Admin extends HttpServlet {

    public static final String HTML_START="<html><body>";
    public static final String HTML_END="</body></html>";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print(HTML_START + " Hello, Admin" + HTML_END);

    }
}


