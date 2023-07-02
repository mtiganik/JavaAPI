package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    static final String QUERY_GET_PERSONS = "select Personid,LastName,FirstName,Age from sys.persons";
    static final String QUERY_GET_POSTS = "select * from posts";

    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.load();
        Connection conn = DatabaseUtils.createConnection("com.mysql.cj.jdbc.Driver", dotenv.get("DB_URL"),dotenv.get("DB_USER"),
                dotenv.get("DB_PASS"));

        var results = getMaps(conn, QUERY_GET_POSTS);

        for(var i : results){
            System.out.println(i);
        }



    }

    private static List<Map<String, Object>> getMaps(Connection conn, String query) {
        ResultSet rs;
        PreparedStatement p;
        List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
        try{
            p = conn.prepareStatement(query);
            rs = p.executeQuery();
            // Extract data from result set
            results = DatabaseUtils.map(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
}
