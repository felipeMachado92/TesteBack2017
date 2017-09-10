package ContaCliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Felipe
 */
public class ConnectionFactory {
    public Connection getConnection() throws Exception{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "");
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
