package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private Connection connection = null; // Connection object to manage database connection
    private static Database instance = null; // Singleton instance of Database class

    // Private constructor to prevent instantiation from outside the class
    private Database() {
        try {
            // Establishing a connection to the PostgreSQL database
            this.connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/rentacar", // JDBC URL for PostgreSQL database
                    "postgres", // Database username
                    "postgres" // Database password
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Print error message if connection fails
        }
    }

    // Method to get the connection object
    public Connection getConnection() {
        return connection; // Return the connection object
    }

    // Method to get the singleton instance of Database class
    public static Connection getInstance()  {
        try {
            // Check if the instance is null or connection is closed
            if (instance == null || instance.getConnection().isClosed()) {
                // Create a new instance of Database and return its connection
                instance = new Database();
                return instance.getConnection();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Print error message if connection check fails
        }
        return instance.getConnection(); // Return the connection of the existing instance
    }
}
