package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        String url="jdbc:mysql://localhost:3306/flipkart";
        String user="root";
        String pass="amruth@123";
        return DriverManager.getConnection(url,user,pass);
    }

}
