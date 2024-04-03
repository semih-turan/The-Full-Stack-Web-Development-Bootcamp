package business;

import core.Helper;
import dao.BookDao;
import dao.CarDao;
import entity.Book;
import entity.Car;
import entity.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CarManager {

    // DAO for Car operations
    private final CarDao carDao;

    // DAO for Book operations
    private final BookDao bookDao;

    // Constructor to initialize dependencies
    public CarManager() {
        this.carDao = new CarDao(); // Initialize CarDao instance
        this.bookDao = new BookDao(); // Initialize BookDao instance
    }

    // Retrieve a car by its ID
    public Car getById(int id) {
        return this.carDao.getById(id); // Retrieve a car using CarDao instance
    }

    // Retrieve all cars
    public ArrayList<Car> findAll() {
        return this.carDao.findByAll(); // Retrieve all cars using CarDao instance
    }

    // Get car information for table display
    public ArrayList<Object[]> getForTable(int size, ArrayList<Car> cars) {
        ArrayList<Object[]> carList = new ArrayList<>();
        for (Car obj : cars) {
            int i = 0;
            Object[] rowObject = new Object[size];
            // Populate the rowObject with car information
            rowObject[i++] = obj.getId();
            rowObject[i++] = obj.getModel().getBrand().getName();
            rowObject[i++] = obj.getModel().getName();
            rowObject[i++] = obj.getPlate();
            rowObject[i++] = obj.getColor();
            rowObject[i++] = obj.getKm();
            rowObject[i++] = obj.getModel().getYear();
            rowObject[i++] = obj.getModel().getType();
            rowObject[i++] = obj.getModel().getFuel();
            rowObject[i++] = obj.getModel().getGear();
            carList.add(rowObject);
        }
        return carList;
    }

    // Save a new car
    public boolean save(Car car) {
        // Check if the car with the same ID already exists
        if (this.getById(car.getId()) != null) {
            Helper.showMessage("Error: Car with ID " + car.getId() + " already exists.");
            return false;
        }
        return this.carDao.save(car); // Save the car using CarDao instance
    }

    // Update an existing car
    public boolean update(Car car) {
        // Check if the car with the given ID exists before updating
        if (this.getById(car.getId()) == null) {
            Helper.showMessage("Error: Car with ID " + car.getId() + " not found for update.");
            return false;
        }
        return this.carDao.update(car); // Update the car using CarDao instance
    }

    // Delete a car by its ID
    public boolean delete(int id) {
        // Check if the car with the given ID exists before deleting
        if (this.getById(id) == null) {
            Helper.showMessage("Error: Car with ID " + id + " not found for deletion.");
            return false;
        }
        return this.carDao.delete(id); // Delete the car using CarDao instance
    }

    // Search for available cars for booking
    public ArrayList<Car> searchForBooking(String strt_date, String fnsh_date, Model.Type type, Model.Gear gear, Model.Fuel fuel) {
        // Base query to select cars and join with models
        String query = "SELECT * FROM public.car as c LEFT JOIN public.model as m";

        // Lists to store conditions for WHERE clause
        ArrayList<String> where = new ArrayList<>();
        ArrayList<String> joinWhere = new ArrayList<>();
        ArrayList<String> bookOrWhere = new ArrayList<>();

        // Add join condition for models
        joinWhere.add("c.car_model_id = m.model_id");

        // Parse date strings into LocalDate format
        strt_date = LocalDate.parse(strt_date, DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString();
        fnsh_date = LocalDate.parse(fnsh_date, DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString();

        // Add conditions for model attributes (type, gear, fuel)
        if (fuel != null) {
            where.add("m.model_fuel = '" + fuel.toString() + "'");
        }

        if (gear != null) {
            where.add("m.model_gear = '" + gear.toString() + "'");
        }

        if (type != null) {
            where.add("m.model_type = '" + type.toString() + "'");
        }

        // Concatenate WHERE conditions
        String whereStr = String.join(" AND ", where);
        String joinStr = String.join(" AND ", joinWhere);

        // Add join condition to the base query
        if (joinStr.length() > 0) {
            query += " ON " + joinStr;
        }

        // Add WHERE conditions to the base query
        if (whereStr.length() > 0) {
            query += " WHERE " + whereStr;
        }

        // Execute query to get a list of searched cars
        ArrayList<Car> searchedCarList = this.carDao.selectByQuery(query);

        // Conditions for checking if cars are booked during the given date range
        bookOrWhere.add("('" + strt_date + "' BETWEEN book_strt_date AND book_fnsh_date)");
        bookOrWhere.add("('" + fnsh_date + "' BETWEEN book_strt_date AND book_fnsh_date)");
        bookOrWhere.add("(book_strt_date BETWEEN '" + strt_date + "' AND '" + fnsh_date + "')");
        bookOrWhere.add("(book_fnsh_date BETWEEN '" + strt_date + "' AND '" + fnsh_date + "')");

        // Concatenate OR conditions for booked cars
        String bookOrWhereStr = String.join(" OR ", bookOrWhere);

        // Query to get booked cars during the given date range
        String bookQuery = "SELECT * FROM public.book WHERE " + bookOrWhereStr;

        // Execute query to get a list of booked cars
        ArrayList<Book> bookList = this.bookDao.selectByQuery(bookQuery);

        // List to store IDs of booked cars
        ArrayList<Integer> busyCarId = new ArrayList<>();

        // Populate the list of booked car IDs
        for (Book book : bookList) {
            busyCarId.add(book.getCar_id());
        }

        // Remove booked cars from the searched car list
        searchedCarList.removeIf(car -> busyCarId.contains(car.getId()));

        return searchedCarList; // Return the list of available cars for booking
    }
}
