package business;

import core.Helper; // Importing the Helper class from the core package
import dao.ModelDao; // Importing the ModelDao class from the dao package
import entity.Model; // Importing the Model class from the entity package

import java.util.ArrayList; // Importing ArrayList from java.util package
import java.util.Objects; // Importing Objects class from java.util package

public class ModelManager {
    private final ModelDao modelDao = new ModelDao(); // Creating an instance of ModelDao

    // Method to retrieve a model by its ID
    public Model getById(int id) {
        return this.modelDao.getById(id); // Calling the getById method of ModelDao
    }

    // Method to retrieve all models
    public ArrayList<Model> findAll() {
        return this.modelDao.findAll(); // Calling the findAll method of ModelDao
    }

    // Method to prepare data for a table view
    public ArrayList<Object[]> getForTable(int size, ArrayList<Model> modelList) {
        ArrayList<Object[]> modelObjectList = new ArrayList<>(); // Creating a list to hold table data
        for (Model object : modelList) {
            int i = 0;
            Object[] rowObject = new Object[size];
            // Populating the rowObject array with model attributes
            rowObject[i++] = object.getId();
            rowObject[i++] = object.getBrand().getName();
            rowObject[i++] = object.getName();
            rowObject[i++] = object.getType();
            rowObject[i++] = object.getYear();
            rowObject[i++] = object.getFuel();
            rowObject[i++] = object.getGear();
            modelObjectList.add(rowObject); // Adding the rowObject to the list
        }
        return modelObjectList; // Returning the list of table data
    }

    // Method to save a model
    public boolean save(Model model) {
        // Checking if a model with the same ID already exists
        if (this.getById(model.getId()) != null) {
            // Showing an error message if the model already exists
            Helper.showMessage("Error: Model with ID " + model.getId() + " already exists.");
            return false; // Returning false to indicate failure
        }
        return this.modelDao.save(model); // Calling the save method of ModelDao
    }

    // Method to update a model
    public boolean update(Model model) {
        // Checking if the model exists
        if (this.getById(model.getId()) == null) {
            // Showing a message if the model doesn't exist
            Helper.showMessage(model.getId() + " This model not found !");
            return false; // Returning false to indicate failure
        }
        return this.modelDao.update(model); // Calling the update method of ModelDao
    }

    // Method to delete a model by its ID
    public boolean delete(int id) {
        // Checking if the model exists
        if (this.getById(id) == null) {
            // Showing a message if the model doesn't exist
            Helper.showMessage(id + " This model not found !");
            return false; // Returning false to indicate failure
        }
        return this.modelDao.delete(id); // Calling the delete method of ModelDao
    }

    // Method to retrieve models by brand ID
    public ArrayList<Model> getByListBrandId(int brandId) {
        return this.modelDao.getByListBrandId(brandId); // Calling the getByListBrandId method of ModelDao
    }

    // Method to search for models based on brand ID, fuel type, model type, and gear type
    public ArrayList<Model> searchForTable(int brand_id, Model.Fuel fuel, Model.Type type, Model.Gear gear) {
        String select = "SELECT * FROM public.model"; // SQL query to select all models
        ArrayList<String> whereList = new ArrayList<>(); // List to hold conditions for WHERE clause

        // Adding brand ID condition if provided
        if (brand_id != 0) {
            whereList.add("model_brand_id = " + brand_id);
        }

        // Adding fuel type condition if provided
        if (fuel != null) {
            whereList.add("model_fuel = '" + fuel.toString() + "'");
        }

        // Adding gear type condition if provided
        if (gear != null) {
            whereList.add("model_gear = '" + gear.toString() + "'");
        }

        // Adding model type condition if provided
        if (type != null) {
            whereList.add("model_type = '" + type.toString() + "'");
        }

        // Constructing the WHERE clause
        String whereStr = String.join(" AND ", whereList);
        String query = select;
        if (!whereStr.isEmpty()) {
            query += " WHERE " + whereStr;
        }

        return this.modelDao.selectByQuery(query); // Calling the selectByQuery method of ModelDao with the constructed query
    }
}
