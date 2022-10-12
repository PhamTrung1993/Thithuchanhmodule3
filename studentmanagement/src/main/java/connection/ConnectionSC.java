package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSC {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/studentclassmanagement?useSSL=false",
                    "root",
                    "123456"
            );
            System.out.println("successful connection");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("connection failed");
        }
        return connection;
    }
}
