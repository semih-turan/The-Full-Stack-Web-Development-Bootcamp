import java.sql.*;

public class DBConnection {
    // Database connection parameters
    public static final String DB_URL = "jdbc:mysql://localhost/JDBCDB";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "mysql";

    // Establishes a connection to the database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    // Retrieves and prints data from the "employees" table
    public static void getData() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM employees")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("employees_id");
                String name = resultSet.getString("employees_name");
                String position = resultSet.getString("employees_position");
                int salary = resultSet.getInt("employees_salary");

                // Print retrieved data
                System.out.println("ID: " + id + " , Name: " + name + " , Position: " + position + ", Salary: " + salary);
            }

        } catch (SQLException e) {
            // Handle SQL exceptions
            System.out.println(e.getMessage());
        }
    }

    // Adds a new record to the "employees" table
    public static void addData(int id, String name, String position, int salary) {
        String sqlQuery = "INSERT INTO employees(employees_id, employees_name, employees_position, employees_salary) VALUES (?,?,?,?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            // Set parameter values for the prepared statement
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, position);
            preparedStatement.setInt(4, salary);

            // Execute the insert query
            int rowNumber = preparedStatement.executeUpdate();
            if (rowNumber > 0) {
                // Print success message if data added successfully
                System.out.println("Data added successfully.");
            } else {
                // Print failure message if data insertion fails
                System.out.println("Failed to add data.");
            }
        } catch (SQLException e) {
            // Handle SQL exceptions
            System.out.println(e.getMessage());
        }
    }

    // Deletes a record from the "employees" table based on the provided ID
    public static void deleteData(int id) {
        String sqlQuery = "DELETE FROM employees WHERE employees_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            // Set parameter value for the prepared statement
            preparedStatement.setInt(1, id);
            // Execute the delete query
            int rowsNumber = preparedStatement.executeUpdate();
            if (rowsNumber > 0) {
                // Print success message if data deleted successfully
                System.out.println("Data deleted successfully");
            } else {
                // Print message if data is not found or deletion fails
                System.out.println("Data is not found or deleted!");
            }
        } catch (SQLException e) {
            // Handle SQL exceptions
            System.out.println(e.getMessage());
        }
    }

    // Updates a record in the "employees" table based on the provided ID
    public static void updateData(int id, String name, String position, int salary) {
        String sqlQuery = "UPDATE employees SET employees_name = ?, employees_position = ?, employees_salary = ? WHERE employees_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            // Set parameter values for the prepared statement
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, position);
            preparedStatement.setInt(3, salary);
            preparedStatement.setInt(4, id);
            // Execute the update query
            int rowsNumber = preparedStatement.executeUpdate();

            if (rowsNumber > 0) {
                // Print success message if data updated successfully
                System.out.println("Data updated successfully");
            } else {
                // Print message if data is not found or update fails
                System.out.println("Data is not found or updated!");
            }
        } catch (SQLException e) {
            // Handle SQL exceptions
            System.out.println(e.getMessage());
        }
    }
}
