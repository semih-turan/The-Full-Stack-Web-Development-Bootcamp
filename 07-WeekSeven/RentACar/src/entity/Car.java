package entity;

// Car class representing a car entity
public class Car {
    // Private fields to store car information
    private int id; // Unique identifier for the car
    private int model_id; // Identifier for the car model
    private Car.Color color; // Color of the car
    private int km; // Kilometers traveled by the car
    private String plate; // License plate number of the car
    private Model model; // Model of the car
    private Brand brand; // Brand of the car

    // Enum for car colors
    public enum Color {
        RED,
        BLUE,
        WHITE,
        GREEN,
        AQUA
    }

    // Default constructor
    public Car() {
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

    // Getter method for model_id
    public int getModel_id() {
        return model_id;
    }

    // Setter method for model_id
    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    // Getter method for color
    public Color getColor() {
        return color;
    }

    // Setter method for color
    public void setColor(Color color) {
        this.color = color;
    }

    // Getter method for km
    public int getKm() {
        return km;
    }

    // Setter method for km
    public void setKm(int km) {
        this.km = km;
    }

    // Getter method for plate
    public String getPlate() {
        return plate;
    }

    // Setter method for plate
    public void setPlate(String plate) {
        this.plate = plate;
    }

    // Getter method for model
    public Model getModel() {
        return model;
    }

    // Setter method for model
    public void setModel(Model model) {
        this.model = model;
    }

    // Getter method for brand
    public Brand getBrand() {
        return brand;
    }

    // Setter method for brand
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    // toString() method to provide a string representation of the Car object
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model_id=" + model_id +
                ", color=" + color +
                ", km=" + km +
                ", plate='" + plate + '\'' +
                ", model=" + model +
                ", brand=" + brand +
                '}';
    }
}
