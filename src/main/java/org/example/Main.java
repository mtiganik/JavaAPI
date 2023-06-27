package org.example;

import java.sql.*;

public class Main {
    static final String DB_URL = "jdbc:mysql://localhost:3306/sys";
//    static final String DB_URL= "Server=localhost;Database=JavaWebAPI";
    static final String USER = "mihkel";
    static final String PASS = "A!VeryComplex123Password";
    static final String QUERY = "select Personid,LastName,FirstName,Age from sys.persons";

    public static void main(String[] args) {


        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY)) {
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("ID: " + rs.getInt("Personid"));
                System.out.print(", Age: " + rs.getInt("age"));
                System.out.print(", First: " + rs.getString("FirstName"));
                System.out.println(", Last: " + rs.getString("LastName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
