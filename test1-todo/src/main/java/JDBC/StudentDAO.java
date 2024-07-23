package JDBC;

import java.sql.*;

public class StudentDAO {
    private String driver;
    private String URL;
    private String username;
    private String password;

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void creteTable() throws ClassNotFoundException, SQLException {
       // Class.forName(driver);
        Connection  conn = DriverManager.getConnection(URL,username,password);
        Statement statement = conn.createStatement();
        boolean result = statement.execute("CREATE TABLE IF NOT EXISTS student (\n" +
                "id INT AUTO_INCREMENT PRIMARY KEY, \n" +
                "name VARCHAR(100) NOT NULL, \n" +
                "age INT NOT NULL \n" +
                ");");
        System.out.println(result);
    }
    public void insert() throws ClassNotFoundException, SQLException {
        // Class.forName(driver);
        System.out.println("Inserting student data....");
        Connection  conn = DriverManager.getConnection(URL,username,password);
        Statement statement = conn.createStatement();
        statement.executeUpdate("INSERT INTO student(id,name,age)  VALUES(1,'test',10);");
        conn.close();
    }

    public void update() throws ClassNotFoundException, SQLException {
        // Class.forName(driver);
        System.out.println("Updating student data....");
        Connection  conn = DriverManager.getConnection(URL,username,password);
        Statement statement = conn.createStatement();
        statement.executeUpdate("UPDATE  student SET name = 'Qarib',age = 20 WHERE id  = 1;");
        conn.close();
    }

    public void delete() throws ClassNotFoundException, SQLException {
        // Class.forName(driver);
        System.out.println("Deleting student data....");
        Connection  conn = DriverManager.getConnection(URL,username,password);
        Statement statement = conn.createStatement();
        statement.executeUpdate("DELETE FROM student WHERE id  = 1;");
        conn.close();
    }

    public void selectAll() throws ClassNotFoundException,SQLException{
        System.out.println("Selecting all....");
        Connection  conn = DriverManager.getConnection(URL,username,password);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM student;");
        System.out.println(rs.getInt(1) + " "
        +rs.getString(2)+" "
        +rs.getString(3));
        conn.close();
    }
}
