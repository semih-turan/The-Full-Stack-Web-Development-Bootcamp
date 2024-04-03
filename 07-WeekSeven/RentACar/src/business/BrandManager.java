package business;

import core.Helper;
import dao.BrandDao;
import entity.Brand;
import entity.Model;

import java.util.ArrayList;

public class BrandManager {
    private final BrandDao brandDao;
    private final ModelManager modelManager;

    // Constructor to initialize BrandManager with BrandDao and ModelManager instances
    public BrandManager() {
        this.brandDao = new BrandDao(); // Initialize BrandDao instance
        this.modelManager = new ModelManager(); // Initialize ModelManager instance
    }

    // Method to prepare data for table view
    public ArrayList<Object[]> getForTable(int size) {
        ArrayList<Object[]> brandRowList = new ArrayList<>();
        // Iterate through all brands and construct row objects for each brand
        for (Brand brand : this.findAll()) {
            Object[] rowObject = new Object[size];
            int i = 0;
            rowObject[i++] = brand.getId(); // Add brand ID to rowObject
            rowObject[i++] = brand.getName(); // Add brand name to rowObject
            brandRowList.add(rowObject); // Add rowObject to brandRowList
        }
        return brandRowList; // Return the list of row objects
    }

    // Method to retrieve all brands from the database
    public ArrayList<Brand> findAll() {
        return this.brandDao.findAll(); // Retrieve all brands using BrandDao instance
    }

    // Method to save a brand into the database
    public boolean save(Brand brand) {
        // Check if brand ID is not zero, indicating an existing brand
        if (brand.getId() != 0) {
            Helper.showMessage("This brand is available"); // Display message indicating brand availability
        }
        return this.brandDao.save(brand); // Save the brand using BrandDao instance
    }

    // Method to retrieve a brand by its ID
    public Brand getById(int id) {
        return this.brandDao.getById(id); // Retrieve the brand using its ID using BrandDao instance
    }

    // Method to update a brand in the database
    public boolean update(Brand brand) {
        // Check if the brand with the given ID exists
        if (this.getById(brand.getId()) == null) {
            Helper.showMessage("Not Found !"); // Display message if brand is not found
        }
        return this.brandDao.update(brand); // Update the brand using BrandDao instance
    }

    // Method to delete a brand from the database by its ID
    public boolean delete(int id) {
        // Check if the brand with the given ID exists
        if (this.getById(id) == null) {
            Helper.showMessage("Not Found !"); // Display message if brand is not found
            return false; // Return false indicating deletion failure
        }
        // Delete all models associated with the brand
        for (Model model : this.modelManager.getByListBrandId(id)){
            this.modelManager.delete(model.getId()); // Delete model using ModelManager instance
        }
        return this.brandDao.delete(id); // Delete the brand using BrandDao instance
    }
}
