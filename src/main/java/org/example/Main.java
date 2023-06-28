package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvException;


import java.sql.*;

public class Main {
    static final String QUERY = "select Personid,LastName,FirstName,Age from sys.persons";

    public static void main(String[] args) {

        // Open a connection
        Dotenv dotenv = Dotenv.load();
        try(
                Connection conn = DriverManager.getConnection(dotenv.get("DB_URL"), dotenv.get("DB_USER"),
                dotenv.get("DB_PASS"));
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
