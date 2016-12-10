package com.h3dg3wytch;

import com.h3dg3wytch.database.ProductManager;
import com.h3dg3wytch.models.Cart;
import com.h3dg3wytch.models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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

        HttpSession session = req.getSession();
        String productId = (String) session.getAttribute("product");
        Cart cart = (Cart) session.getAttribute("cart");

        if (req.getParameter("checkout") != null) {
            resp.sendRedirect("/checkout.jsp");
        } else if (req.getParameter("remove") != null) {
            cart.removeFromCart(productId);
            session.setAttribute("cart", cart);
            resp.sendRedirect("/viewCart.jsp");
        }
    }

}