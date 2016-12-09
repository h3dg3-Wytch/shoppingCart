import com.h3dg3wytch.database.*;
import com.h3dg3wytch.models.Cart;
import com.h3dg3wytch.models.Order;
import com.h3dg3wytch.models.Product;
import com.h3dg3wytch.models.User;
import org.junit.Test;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by h3dg3wytch on 12/5/16.
 */
public class DatabaseTest {

    @Test
    public void testDatabase(){
        try {
            DBConnectionManager connectionManager = new DBConnectionManager("jdbc:mysql://localhost/shoppingCart", "developer", "password");
            Connection connection = connectionManager.getConnection();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
            while(resultSet.next()){
                System.out.println(resultSet.getString("firstName"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testUserManager() throws SQLException, ClassNotFoundException {
        UserManager userManager = new UserManager("jdbc:mysql://localhost/shoppingCart", "developer", "password");
        for(User usr: userManager.getUsers().values()){
            System.out.println("First Name: " + usr.getFirstName());
            System.out.println("UserName: " + usr.getUserName());
            System.out.println("Password: " + usr.getPassword());
        }
    }

    @Test
    public void CartTest(){
        Cart cart = new Cart();

        for(int i = 0 ; i < 5; i++){
            Product product = new Product("Product#" + i, 34.3, "image.jpg");
            cart.addToCart(product);
        }

        Product p = new Product("Test", 34, "sdf");
        cart.addToCart(p);

        for (Product o : cart.getProducts() ) {

            System.out.println(o.toString());

        }
        System.out.println();
        if(cart.removeFromCart(p)) {

            for (Product o : cart.getProducts()) {

                System.out.println(o.toString());

            }
        }

    }

//    @Test
//    public void addUsersToManager() throws SQLException, ClassNotFoundException {
//        UserManager userManager = new UserManager("jdbc:mysql://localhost/shoppingCart", "developer", "password");
//        for(int i = 0 ; i < 5; i++){
//            User user = new User("John", "Doe", "testUser#" + i, "password" );
//            userManager.addUser(user);
//        }
//
//        Object[] users = userManager.getUsers().values().toArray().clone();
//        for(int i = 0; i < users.length; i++){
//           User user = (User) users[i];
//            if(user.getFirstName().equals("John") || user.getFirstName().equals("Jack"))
//                userManager.deleteUser(user);
//        }
//
//        for (User user : userManager.getUsers().values()) {
//
//            System.out.println(user);
//
//        }
//    }

    @Test
    public void UUIDtest(){
        String uuid = randomUUID().toString();
        System.out.println(uuid);
    }

    @Test
    public void findUserByUserNameTest() throws SQLException, ClassNotFoundException {

        UserManager userManager = new UserManager("jdbc:mysql://localhost/shoppingCart", "developer", "password");
        User user = userManager.findUserByNameAndPassword("dev", "password");
        System.out.println(user.getUserName());
    }

    /*
    @Test
    public void adminTest() throws SQLException, ClassNotFoundException {
        AdminManager adminManager = new AdminManager("jdbc:mysql://localhost/shoppingCart", "developer", "password");
        System.out.println("Get all values");
        for(String userId: adminManager.getAdmins()){
            System.out.println(userId);
        }

        System.out.println("Insertion");
        adminManager.addUser("dafb59c9-17b3-499b-ac7c-6ad2060ef6a4");
        for(String userId: adminManager.getAdmins()){
            System.out.println(userId);
        }

        System.out.println("Deletion");
        adminManager.removeUserAsAdmin("dafb59c9-17b3-499b-ac7c-6ad2060ef6a4");

        for(String userId: adminManager.getAdmins()){
            System.out.println(userId);
        }


    }
    **/

//    @Test
//    public void orderManagerGetTest() throws SQLException, ClassNotFoundException
//    {
//        OrderManager orderManager = new OrderManager("jdbc:mysql://localhost/shoppingCart", "developer", "password");
//        boolean expected = orderManager.get();
//
//        assertTrue(expected);
//    }

    @Test
    public void orderManagerAddOrderWithNullTest() throws SQLException, ClassNotFoundException
    {
        OrderManager orderManager = new OrderManager("jdbc:mysql://localhost/shoppingCart", "developer", "password");

        boolean expected = orderManager.addOrder(null);

        assertFalse(expected);
    }

//    @Test
//    public void orderManagerAddOrderTest() throws SQLException, ClassNotFoundException
//    {
//        OrderManager orderManager = new OrderManager("jdbc:mysql://localhost/shoppingCart", "developer", "password");
//
//        Order order = new Order(0,"d916c0d9-bd8e-11e6-bd88-bcaec50ef9d8","d8c9d1a8-bd8f-11e6-bd88-bcaec50ef9d8");
//
//        boolean expected = orderManager.addOrder(order);
//        assertTrue(expected);
//    }

    @Test
    public void productManagerAddProductWithNullTest() throws SQLException, ClassNotFoundException
    {
        ProductManager productManager = new ProductManager("jdbc:mysql://localhost/shoppingCart", "developer", "password");

        boolean expected = productManager.addProduct(null);

        assertFalse(expected);
    }

//    @Test
//    public void productManagerAddProductTest() throws SQLException, ClassNotFoundException
//    {
//        ProductManager productManager = new ProductManager("jdbc:mysql://localhost/shoppingCart", "developer", "password");
//
//        Product product = new Product(UUID.randomUUID().toString(),"huh",52,"huh", "huh");
//
//        boolean expected = productManager.addProduct(product);
//
//        assertTrue(expected);
//    }

//    @Test
//    public void productManagerDeleteProductWithNullTest() throws SQLException, ClassNotFoundException
//    {
//        ProductManager productManager = new ProductManager("jdbc:mysql://localhost/shoppingCart", "developer", "password");
//
//        boolean expected = productManager.deleteProduct(null);
//
//        assertFalse(expected);
//    }
//
//
//    @Test
//    public void productManagerDeleteProductTest() throws SQLException, ClassNotFoundException
//    {
//        ProductManager productManager = new ProductManager("jdbc:mysql://localhost/shoppingCart", "developer", "password");
//
//        ArrayList<Product> products = (ArrayList)productManager.getProducts();
//
//
//        Product product = products.get(0);
//
//        boolean expected = productManager.deleteProduct(product);
//
//        assertTrue(expected);
//    }

 
}
