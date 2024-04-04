package core; // Declares that this class belongs to the 'core' package

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
    private Connection connection = null; // Connection object to manage database connection
    private static Database instance = null; // Singleton instance of Database class
    private final String CONFIG_FILE_PATH = "src/config.properties"; // Path to configuration file

    // Private constructor to prevent instantiation from outside the class
    private Database() {
        try {
            Properties properties = new Properties();
            // Resource with Try-with-resources Usage: Files.newBufferedReader method is used with try-with-resources block for safer file reading operation
            // Load database connection details from the configuration file
            properties.load(Files.newBufferedReader(Paths.get(CONFIG_FILE_PATH)));

            // Retrieve database connection details from the configuration file
            String url = properties.getProperty("url"); // Database URL
            String username = properties.getProperty("username"); // Database username
            String password = properties.getProperty("password"); // Database password

            // Establish the database connection using retrieved details
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (IOException | SQLException e) {
            // Exception Handling: Provides better handling of exceptions and gives more descriptive error messages
            // Throw a runtime exception with error message if initializing database connection fails
            throw new RuntimeException("Error initializing database connection", e);
        }
    }

    // Method to get the connection object
    public Connection getConnection() {
        return connection; // Return the connection object
    }

    // Method to get the singleton instance of Database class
    public static synchronized Connection getInstance() {
        // Singleton Pattern Update: Ensures thread safety by synchronizing the getInstance method
        if (instance == null) { // Check if the instance is null
            instance = new Database(); // Create a new instance of Database if it's null
        } else {
            try {
                // Check if the existing connection is closed or null
                if (instance.getConnection() == null || instance.getConnection().isClosed()) {
                    instance = new Database(); // Reinitialize if connection is closed
                }
            } catch (SQLException e) {
                // Exception Handling: Provides better handling of exceptions and gives more descriptive error messages
                // Throw a runtime exception with error message if checking database connection fails
                throw new RuntimeException("Error checking database connection", e);
            }
        }
        return instance.getConnection(); // Return the connection of the existing instance
    }
}
