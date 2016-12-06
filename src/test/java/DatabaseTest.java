import com.h3dg3wytch.database.DBConnectionManager;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
