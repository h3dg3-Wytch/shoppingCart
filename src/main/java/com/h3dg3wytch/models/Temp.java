package com.h3dg3wytch.models;

import com.h3dg3wytch.database.ProductManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * Created by h3dg3wytch on 12/9/16.
 */

@WebServlet(description = "Temp Page", urlPatterns = {"/Temp"})
public class Temp extends HttpServlet {

    public static final String HTML_START="<html><body>";
    public static final String HTML_END="</body></html>";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        out.print(HTML_START);

        out.print(HTML_START);
        out.print("<p>" + req.getAttribute("purchase")+ "</p>");
        for (Enumeration<String> e = req.getAttributeNames(); e.hasMoreElements();){
            String name = (String) e.nextElement();
            // Get the value of the attribute
            Object value = getServletContext().getAttribute(name);

            if (value instanceof Map) {
                for (Map.Entry<?, ?> entry : ((Map<?, ?>)value).entrySet()) {
                    System.out.println(entry.getKey() + "=" + entry.getValue());
                }
            } else if (value instanceof List) {
                for (Object element : (List)value) {
                    System.out.println(element);
                }
            }
        }
        out.print(HTML_END);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        out.print(HTML_START);
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        String productId = getIdFromURLQuery(req.getQueryString());

        ProductManager productManager = null;

        try {
            productManager = new ProductManager(getServletContext().getInitParameter("dbURL"),getServletContext().getInitParameter("dbUser"),getServletContext().getInitParameter("dbPassword") );
            ArrayList<Product> products = productManager.getProducts();
            for (Product product : products) {
                out.print("<p>" + product + "</p>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            out.print("<p>BAD SQL</p>");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.print("<p>BAD CLASS</p>");
        }

//        if(product != null) {
//            cart.addToCart(product);
//        }
//        session.setAttribute("cart", cart);


        out.print(HTML_END);
        //resp.sendRedirect("inventory.jsp");

    }

    private String getIdFromURLQuery(String urlQuery){
        return urlQuery.substring(9);
    }
}
