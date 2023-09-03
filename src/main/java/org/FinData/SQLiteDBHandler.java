package org.FinData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLiteDBHandler {
    private static final String DB_URL = "jdbc:sqlite:/path/to/your/database.db"; // Replace with your database path

    public static void insertJSONData (String jsonData) {
        try (Connection connection = DriverManager.getConnection (DB_URL);
             PreparedStatement preparedStatement = connection.prepareStatement ("INSERT INTO your_table_name(json_data) VALUES (?)")) {

            preparedStatement.setString (1, jsonData);
            preparedStatement.executeUpdate ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }
}