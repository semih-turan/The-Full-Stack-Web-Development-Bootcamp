package entity;

// Brand class representing a brand entity
public class Brand {
    // Private fields to store brand information
    private int id; // Unique identifier for the brand
    private String name; // Name of the brand

    // Constructors
    // Constructor with id and name parameters
    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Constructor with only name parameter
    public Brand(String name) {
        this.name = name;
    }

    // Default constructor
    public Brand() {
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

    // Getter method for name
    public String getName() {
        return name;
    }

    // Setter method for name
    public void setName(String name) {
        this.name = name;
    }
}