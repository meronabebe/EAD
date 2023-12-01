package taskmanagementsystem;

import java.sql.*;
public class database {
public static void main(String[] args) throws SQLException {
String jdbcURL = "jdbc:mysql://localhost:3306/usersdb";
String username = "root";
String pwd = "baba11@";
Connection connection = DriverManager.getConnection(jdbcURL,
username, pwd);
Statement statement = connection.createStatement();
String query = "Select * from teachers";
String createTableSQL = "CREATE TABLE use (" +
"id int auto_increment primary key," +
"username varchar(255)," +
"password varchar(255)," +
"email varchar(255)";
statement.executeUpdate(createTableSQL);
System.out.println("Ttable ‘use’ created successfully.");
}
}