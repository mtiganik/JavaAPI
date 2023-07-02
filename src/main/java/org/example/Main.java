package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    static final String QUERY = "select Personid,LastName,FirstName,Age from sys.persons";

    public static void main(String[] args) {
        DatabaseUtils utils = new DatabaseUtils();
        Dotenv dotenv = Dotenv.load();
        List<Person> results = new ArrayList<Person>();
        Connection conn = utils.createConnection("com.mysql.cj.jdbc.Driver", dotenv.get("DB_URL"),dotenv.get("DB_USER"),
                dotenv.get("DB_PASS"));
        // Open a connection
        try(
                Statement stmt = conn.createStatement();
//                results = utils.map(stmt.executeQuery(QUERY));
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
