package com.h3dg3wytch.database;

import com.h3dg3wytch.models.Order;
import com.h3dg3wytch.models.Product;
import com.h3dg3wytch.models.User;

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
import java.util.HashMap;

/**
 * Created by h3dg3wytch on 12/9/16.
 */

@WebServlet(description = "Profile Controller", urlPatterns = {"/Profile"})
public class Profile extends HttpServlet {

    public static final String HTML_START="<html><body>";
    public static final String HTML_END="</body></html>";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session =  req.getSession();
        User user = (User) session.getAttribute("user");

        HashMap<Integer, Order> orders = null;

        ProductManager productManager = null;
        OrderManager orderManager = null;

        try {
            productManager = new ProductManager(getServletContext().getInitParameter("dbURL"),
                    getServletContext().getInitParameter("dbUser"),
                    getServletContext().getInitParameter("dbUserPwd")
            );
            orderManager = new OrderManager(getServletContext().getInitParameter("dbURL"),
                    getServletContext().getInitParameter("dbUser"),
                    getServletContext().getInitParameter("dbUserPwd")
            );

            orders = orderManager.getOrders();

            ArrayList<Product> pastOrders = new ArrayList<>();
            for (Integer integer : orders.keySet()) {
                if(orders.get(integer).getUserId().equals(user.getUserId())){
                    //Gets the order, then gets the id of the product in the order
                    String productId = orders.get(integer).getProductId();
                    Product product = productManager.findProduct(productId);
                    pastOrders.add(product);
                }
            }

            session.setAttribute("orderHistory", pastOrders );




        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {

            try {
                productManager.getDbConnectionManager().getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        resp.sendRedirect("profile.jsp");


    }
}
