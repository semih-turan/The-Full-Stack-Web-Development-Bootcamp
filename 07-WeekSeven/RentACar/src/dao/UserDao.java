package dao;

import core.Database;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {

    private final Connection connection; // Connection object for database operations

    // Constructor to initialize UserDao with a database connection
    public UserDao() {
        this.connection = Database.getInstance(); // Get a database connection instance
    }

    // Method to retrieve all users from the database
    public ArrayList<User> findAll() {
        ArrayList<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM public.user";

        try {
            ResultSet resultSet = this.connection.createStatement().executeQuery(sql);
            // Iterate through the result set and add each user to the list
            while (resultSet.next()) {
                userList.add(this.match(resultSet)); // Convert ResultSet to User object and add to the list
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if an SQLException occurs
        }
        return userList; // Return the list of users
    }

    // Method to find a user by login credentials (username and password) from the database
    public User findByLogin(String username, String password) {
        User object = null;
        String query = "SELECT * FROM public.user WHERE user_name = ? AND user_password = ?";

        try {
            PreparedStatement prepared = this.connection.prepareStatement(query);
            // Set parameters for the query
            prepared.setString(1, username);
            prepared.setString(2, password);

            ResultSet resultSet = prepared.executeQuery();
            if (resultSet.next()) {
                object = this.match(resultSet); // Convert ResultSet to User object
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if an SQLException occurs
        }
        return object; // Return the User object found by login credentials
    }

    // Method to map the ResultSet to a User object
    public User match(ResultSet resultSet) throws SQLException {
        User object = new User();
        // Set attributes of the User object using data from the ResultSet
        object.setId(resultSet.getInt("user_id"));
        object.setUsername(resultSet.getString("user_name"));
        object.setPassword(resultSet.getString("user_password"));
        object.setRole(resultSet.getString("user_role"));
        return object; // Return the User object
    }

}
