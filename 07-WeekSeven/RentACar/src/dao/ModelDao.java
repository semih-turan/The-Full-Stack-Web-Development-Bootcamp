package dao;

import core.Database;
import entity.Brand;
import entity.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelDao {
    private Connection connection; // Connection object for database operations
    private final BrandDao brandDao = new BrandDao(); // BrandDao instance for handling brand-related operations

    // Constructor to initialize ModelDao with a database connection
    public ModelDao() {
        this.connection = Database.getInstance(); // Get a database connection instance
    }

    // Method to retrieve a model by its ID from the database
    public Model getById(int id) {
        Model object = null;
        String query = "SELECT * FROM public.model WHERE model_id = ?";
        try {
            PreparedStatement prepared = this.connection.prepareStatement(query);
            prepared.setInt(1, id);
            ResultSet resultSet = prepared.executeQuery();
            if (resultSet.next()) {
                object = this.match(resultSet); // Convert ResultSet to Model object
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace(); // Print stack trace if an SQLException occurs
        }
        return object; // Return the Model object
    }

    // Method to retrieve all models from the database
    public ArrayList<Model> findAll() {
        return this.selectByQuery("SELECT * FROM public.model ORDER BY model_id ASC");
    }

    // Method to retrieve models by a given brand ID from the database
    public ArrayList<Model> getByListBrandId(int brandId) {
        return this.selectByQuery("SELECT * FROM public.model WHERE model_brand_id = " + brandId);
    }

    // Method to retrieve models based on a custom query
    public ArrayList<Model> selectByQuery(String query) {
        ArrayList<Model> modelList = new ArrayList<>();
        try {
            ResultSet rs = this.connection.createStatement().executeQuery(query);
            // Iterate through the result set and add each model to the list
            while (rs.next()) {
                modelList.add(this.match(rs)); // Convert ResultSet to Model object and add to the list
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if an SQLException occurs
        }
        return modelList; // Return the list of models
    }

    // Method to save a new model to the database
    public boolean save(Model model) {
        String query = "INSERT INTO public.model " +
                "(model_brand_id, model_name, model_type, model_year, model_fuel, model_gear) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement prepared = this.connection.prepareStatement(query);
            // Set parameters for the insert query
            prepared.setInt(1, model.getBrand_id());
            prepared.setString(2, model.getName());
            prepared.setString(3, model.getType().toString());
            prepared.setString(4, model.getYear());
            prepared.setString(5, model.getFuel().toString());
            prepared.setString(6, model.getGear().toString());
            // Execute the insert and return true if successful
            return prepared.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if an SQLException occurs
        }
        return false; // Return false by default
    }

    // Method to update an existing model in the database
    public boolean update(Model model) {
        String query = "UPDATE public.model SET " +
                "model_brand_id = ?, " +
                "model_name = ?, " +
                "model_type = ?, " +
                "model_year = ?, " +
                "model_fuel = ?, " +
                "model_gear = ? " +
                "WHERE model_id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            // Set parameters for the update query
            ps.setInt(1, model.getBrand_id());
            ps.setString(2, model.getName());
            ps.setString(3, model.getType().toString());
            ps.setString(4, model.getYear());
            ps.setString(5, model.getFuel().toString());
            ps.setString(6, model.getGear().toString());
            ps.setInt(7, model.getId());
            // Execute the update and return true if successful
            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if an SQLException occurs
        }
        return true; // Return true by default
    }

    // Method to delete a model from the database by its ID
    public boolean delete(int model_id) {
        String query = "DELETE FROM public.model WHERE model_id = ?";
        try {
            PreparedStatement prepared = this.connection.prepareStatement(query);
            // Set the model ID parameter for the delete query
            prepared.setInt(1, model_id);
            // Execute the delete and return true if successful
            return prepared.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace(); // Print stack trace if an SQLException occurs
        }
        return true; // Return true by default
    }

    // Method to map the ResultSet to a Model object
    public Model match(ResultSet resultSet) throws SQLException {
        Model model = new Model();
        // Set attributes of the Model object using data from the ResultSet
        model.setId(resultSet.getInt("model_id"));
        model.setName(resultSet.getString("model_name"));
        model.setFuel(Model.Fuel.valueOf(resultSet.getString("model_fuel")));
        model.setGear(Model.Gear.valueOf(resultSet.getString("model_gear")));
        model.setType(Model.Type.valueOf(resultSet.getString("model_type")));
        model.setYear(resultSet.getString("model_year"));
        model.setBrand(this.brandDao.getById(resultSet.getInt("model_brand_id"))); // Set the brand of the model
        model.setBrand_id(resultSet.getInt("model_brand_id")); // Set the brand ID of the model
        return model; // Return the Model object
    }
}
