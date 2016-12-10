package com.h3dg3wytch.database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by h3dg3wytch on 12/9/16.
 */
@WebServlet(description = "Checkout Page", urlPatterns = {"/Checkout"})

public class Checkout extends HttpServlet {

    public static final String HTML_START="<html><body>";
    public static final String HTML_END="</body></html>";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println(HTML_START);
        if(req.getParameter("checkout") != null){
            out.print(req.getParameter("product"));
        }
        out.println(HTML_END);
    }
}
