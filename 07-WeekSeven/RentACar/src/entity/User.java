package entity;

// Entity class representing a user
public class User {
    // Private fields to store user information
    private int id; // Unique identifier for the user
    private String username; // Username of the user
    private String password; // Password of the user
    private String role; // Role of the user (e.g., admin, user)

    // Default constructor
    public User() {
    }

    // Parameterized constructor to initialize user fields
    public User(int id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
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

    // Getter method for username
    public String getUsername() {
        return username;
    }

    // Setter method for username
    public void setUsername(String userName) {
        this.username = userName;
    }

    // Getter method for password
    public String getPassword() {
        return password;
    }

    // Setter method for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter method for role
    public String getRole() {
        return role;
    }

    // Setter method for role
    public void setRole(String role) {
        this.role = role;
    }

    // toString method to represent User object as a string
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
