package business;

import dao.UserDao;
import entity.User;

public class UserManager {
    private final UserDao userDao; // UserDao instance for handling user-related database operations

    // Constructor to initialize UserDao instance
    public UserManager() {
        this.userDao = new UserDao(); // Initialize UserDao instance
    }

    // Method to find a user by login credentials (username and password)
    public User findByLogin(String username, String password){
        // Perform operations like validation, authentication, etc.
        // Here, it simply delegates the task to UserDao to find a user by login credentials
        return this.userDao.findByLogin(username,password); // Return the user found by UserDao
    }
}
