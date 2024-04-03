package core;

public class ComboItem {
    private int key; // Represents the key associated with the ComboItem
    private String value; // Represents the value associated with the ComboItem

    // Constructor to initialize ComboItem with key and value
    public ComboItem(int key, String value) {
        this.key = key; // Set the key
        this.value = value; // Set the value
    }

    // Getter for key
    public int getKey() {
        return key; // Return the key associated with the ComboItem
    }

    // Setter for key
    public void setKey(int key) {
        this.key = key; // Set the key of the ComboItem
    }

    // Getter for value
    public String getValue() {
        return value; // Return the value associated with the ComboItem
    }

    // Setter for value
    public void setValue(String value) {
        this.value = value; // Set the value of the ComboItem
    }

    // Override toString() method to return the value when ComboItem is converted to a string
    @Override
    public String toString() {
        return this.value; // Return the value of the ComboItem as a string
    }
}
