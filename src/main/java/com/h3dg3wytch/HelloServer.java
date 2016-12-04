package com.h3dg3wytch;

//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(description = "Test Servlet", urlPatterns = { "/"})
public class HelloServer extends HttpServlet{

    private static final long serialVersionUID = 1L;
    public static final String HTML_START="<html><body>";
    public static final String HTML_END="</body></html>";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Date date = new Date();
        out.println(HTML_START + "<h2>Hi There!</h2><br/><h3>Date="+date +"</h3>"+HTML_END);
    }

}
/**
 * Created by h3dg3wytch on 11/16/16.
 */
//
//public class HelloServer extends HttpServlet {
//
//    private String message;
//
//    public void init() throws ServletException
//    {
//        // Do required initialization
//        message = "Hello World";
//    }
//
//    public void doGet(HttpServletRequest request,
//                      HttpServletResponse response)
//            throws ServletException, IOException
//    {
//        // Set response content type
//        response.setContentType("text/html");
//
//        // Actual logic goes here.
//        PrintWriter out = response.getWriter();
//        out.println("<h1>" + message + "</h1>");
//    }
//
//    public void destroy()
//    {
//        // do nothing.
//    }
//
//}
//
//
