import com.h3dg3wytch.database.DBConnectionManager;
import com.h3dg3wytch.database.UserManager;
import com.h3dg3wytch.models.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import static java.util.UUID.randomUUID;

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

//    @Test
//    public void addUsersToManager() throws SQLException, ClassNotFoundException {
//        UserManager userManager = new UserManager("jdbc:mysql://localhost/shoppingCart", "developer", "password");
//        for(int i = 0 ; i < 20; i++){
//            User user = new User("John", "Doe", "testUser#" + i, "password" );
//            userManager.addUser(user);
//        }
//
//        for(User usr: userManager.getUsers().values()){
//            System.out.println("First Name: " + usr.getFirstName());
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
}
