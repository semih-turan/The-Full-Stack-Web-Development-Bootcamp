package entity;

import core.ComboItem;

// Model class representing a car model entity
public class Model {
    // Private fields to store model information
    private int id; // Unique identifier for the model
    private int brand_id; // Identifier for the brand of the model
    private String name; // Name of the model
    private Type type; // Type of the model (e.g., Sedan, Hatchback)
    private String year; // Year of the model
    private String string; // A string field (name seems inappropriate)
    private Fuel fuel; // Fuel type of the model
    private Gear gear; // Gear type of the model
    private Brand brand; // Brand of the model

    // Enum for fuel types
    public enum Fuel {
        GASOLINE,
        LPG,
        ELECTRIC,
        DIESEL
    }

    // Enum for gear types
    public enum Gear {
        MANUAL,
        AUTO
    }

    // Enum for model types
    public enum Type {
        SEDAN,
        HATCHBACK
    }

    // Default constructor
    public Model() {
    }

    // Getter and setter methods for private fields

    // Getter method for id
    public int getId() {
        return id;
    }

    // Setter method for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter method for brand_id
    public int getBrand_id() {
        return brand_id;
    }

    // Setter method for brand_id
    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Setter method for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for type
    public Type getType() {
        return type;
    }

    // Setter method for type
    public void setType(Type type) {
        this.type = type;
    }

    // Getter method for year
    public String getYear() {
        return year;
    }

    // Setter method for year
    public void setYear(String year) {
        this.year = year;
    }

    // Getter method for string
    public String getString() {
        return string;
    }

    // Setter method for string
    public void setString(String string) {
        this.string = string;
    }

    // Getter method for fuel
    public Fuel getFuel() {
        return fuel;
    }

    // Setter method for fuel
    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    // Getter method for gear
    public Gear getGear() {
        return gear;
    }

    // Setter method for gear
    public void setGear(Gear gear) {
        this.gear = gear;
    }

    // Getter method for brand
    public Brand getBrand() {
        return brand;
    }

    // Setter method for brand
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    // Method to create a ComboItem for the model
    public ComboItem getComboItem() {
        // Combine model information into a single string and create a ComboItem
        return new ComboItem(this.getId(), this.getBrand().getName() + " - " + this.getName() + " - " + this.getYear() + " - " + this.getGear());
    }
}
