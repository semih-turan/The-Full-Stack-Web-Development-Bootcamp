package dao;

import core.Database;
import entity.Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BrandDao {

    private final Connection connection; // Connection object for database operations

    // Constructor to initialize BrandDao with a database connection
    public BrandDao() {
        this.connection = Database.getInstance(); // Get a database connection instance
    }

    // Method to retrieve all brands from the database
    public ArrayList<Brand> findAll() {
        ArrayList<Brand> brandList = new ArrayList<>();
        String sql = "SELECT * FROM public.brand ORDER BY brand_id ASC"; // SQL query to select all brands
        try {
            ResultSet resultSet = this.connection.createStatement().executeQuery(sql);
            // Iterate through the result set and add each brand to the list
            while (resultSet.next()) {
                brandList.add(this.match(resultSet)); // Convert ResultSet to Brand object and add to the list
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if an SQLException occurs
        }
        return brandList; // Return the list of brands
    }

    // Method to save a new brand to the database
    public boolean save(Brand brand) {
        String query = "INSERT INTO public.brand (brand_name) VALUES (?)"; // SQL query to insert a new brand
        try {
            PreparedStatement prepared = this.connection.prepareStatement(query);
            prepared.setString(1, brand.getName()); // Set brand name parameter
            // Execute the update and return true if successful
            return prepared.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if an SQLException occurs
        }
        return true; // Return true by default
    }

    // Method to update an existing brand in the database
    public boolean update(Brand brand) {
        String query = "UPDATE public.brand SET brand_name = ? WHERE brand_id = ?"; // SQL query to update a brand
        try {
            PreparedStatement prepared = this.connection.prepareStatement(query);
            prepared.setString(1, brand.getName()); // Set brand name parameter
            prepared.setInt(2, brand.getId()); // Set brand ID parameter
            // Execute the update and return true if successful
            return prepared.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if an SQLException occurs
        }
        return true; // Return true by default
    }

    // Method to delete a brand from the database by its ID
    public boolean delete(int id) {
        String query = "DELETE FROM public.brand WHERE brand_id = ?"; // SQL query to delete a brand
        try {
            PreparedStatement prepared = this.connection.prepareStatement(query);
            prepared.setInt(1, id); // Set brand ID parameter
            // Execute the update and return true if successful
            return prepared.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if an SQLException occurs
        }
        return true; // Return true by default
    }

    // Method to retrieve a brand from the database by its ID
    public Brand getById(int id) {
        Brand object = null;
        String query = "SELECT * FROM public.brand WHERE brand_id = ? "; // SQL query to select a brand by ID
        try {
            PreparedStatement prepared = this.connection.prepareStatement(query);
            prepared.setInt(1, id); // Set brand ID parameter
            ResultSet resultSet = prepared.executeQuery();
            if (resultSet.next()) {
                object = this.match(resultSet); // Convert ResultSet to Brand object
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if an SQLException occurs
        }
        return object; // Return the Brand object
    }

    // Method to convert a ResultSet to a Brand object
    public Brand match(ResultSet resultSet) throws SQLException {
        Brand object = new Brand();
        // Set attributes of the Brand object using data from the ResultSet
        object.setId(resultSet.getInt("brand_id"));
        object.setName(resultSet.getString("brand_name"));
        return object; // Return the Brand object
    }
}
