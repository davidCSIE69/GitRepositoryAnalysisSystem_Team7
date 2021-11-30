package database;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection getConnection() {
        try {
            new Driver();
            return DriverManager.getConnection("jdbc:mysql://localhost:33010/gras?user=root&password=12345&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            return null;
        }
    }
}

