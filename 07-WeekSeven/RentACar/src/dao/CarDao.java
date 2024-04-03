package dao;

import core.Database;
import entity.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarDao {
    private Connection con; // Connection object for database operations
    private final ModelDao modelDao; // ModelDao instance for handling model-related operations
    private final BrandDao brandDao; // BrandDao instance for handling brand-related operations

    // Constructor to initialize CarDao with a database connection
    public CarDao() {
        this.con = Database.getInstance(); // Get a database connection instance
        this.modelDao = new ModelDao(); // Initialize ModelDao instance
        this.brandDao = new BrandDao(); // Initialize BrandDao instance
    }

    // Method to retrieve a car by its ID from the database
    public Car getById(int id) {
        Car obj = null;
        String query = "SELECT * FROM public.car WHERE car_id = ? ";
        try {
            PreparedStatement ps = this.con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                obj = this.match(rs); // Convert ResultSet to Car object
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if an SQLException occurs
        }
        return obj; // Return the Car object
    }

    // Method to retrieve all cars from the database
    public ArrayList<Car> findByAll() {
        return this.selectByQuery("SELECT * FROM public.car ORDER BY car_id");
    }

    // Method to retrieve cars based on a custom query
    public ArrayList<Car> selectByQuery(String query) {
        ArrayList<Car> cars = new ArrayList<>();
        try {
            ResultSet rs = this.con.createStatement().executeQuery(query);
            // Iterate through the result set and add each car to the list
            while (rs.next()) {
                cars.add(this.match(rs)); // Convert ResultSet to Car object and add to the list
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if an SQLException occurs
        }
        return cars; // Return the list of cars
    }

    // Method to map the ResultSet to a Car object
    public Car match(ResultSet rs) throws SQLException {
        Car car = new Car();
        // Set attributes of the Car object using data from the ResultSet
        car.setId(rs.getInt("car_id"));
        car.setModel_id(rs.getInt("car_model_id"));
        car.setPlate(rs.getString("car_plate"));
        car.setColor(Car.Color.valueOf(rs.getString("car_color")));
        car.setKm(rs.getInt("car_km"));
        car.setModel(this.modelDao.getById(car.getModel_id())); // Set the model of the car
        return car; // Return the Car object
    }

    // Method to update an existing car in the database
    public boolean update(Car car) {
        String query = "UPDATE public.car SET " +
                "car_model_id = ?, " +
                "car_color = ?, " +
                "car_km = ?, " +
                "car_plate = ? " +
                "WHERE car_id = ?";
        try {
            PreparedStatement ps = this.con.prepareStatement(query);
            // Set parameters for the update query
            ps.setInt(1, car.getModel_id());
            ps.setString(2, car.getColor().toString());
            ps.setInt(3, car.getKm());
            ps.setString(4, car.getPlate());
            ps.setInt(5, car.getId());
            // Execute the update and return true if successful
            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if an SQLException occurs
        }
        return true; // Return true by default
    }

    // Method to save a new car to the database
    public boolean save(Car car) {
        String query = "INSERT INTO public.car " +
                "(car_model_id, car_color, car_km, car_plate) " +
                "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = this.con.prepareStatement(query);
            // Set parameters for the insert query
            ps.setInt(1, car.getModel_id());
            ps.setString(2, car.getColor().toString());
            ps.setInt(3, car.getKm());
            ps.setString(4, car.getPlate());
            // Execute the insert and return true if successful
            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if an SQLException occurs
        }
        return true; // Return true by default
    }

    // Method to delete a car from the database by its ID
    public boolean delete(int carId) {
        String query = "DELETE FROM public.car WHERE car_id = ?";
        try {
            PreparedStatement ps = this.con.prepareStatement(query);
            // Set the car ID parameter for the delete query
            ps.setInt(1, carId);
            // Execute the delete and return true if successful
            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if an SQLException occurs
        }
        return true; // Return true by default
    }
}
