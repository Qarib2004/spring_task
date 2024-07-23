package org.todo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static String url = "jdbc:postgresql://localhost:5432/dvdrental";
    private static String user = "postgres";
    private static String password = "javaserver123";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
}
