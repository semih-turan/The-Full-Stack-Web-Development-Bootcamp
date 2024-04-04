package dao;

import core.Database;
import entity.Book;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class BookDao {

    private Connection connection; // Connection object for database operations
    private final CarDao carDao; // CarDao instance for handling car-related operations

    // Constructor to initialize BookDao and CarDao
    public BookDao() {
        this.connection = Database.getInstance(); // Get a database connection instance
        this.carDao = new CarDao(); // Initialize CarDao instance
    }

    // Method to retrieve all books from the database
    public ArrayList<Book> findAll() {
        // Execute query to select all books and return the result
        return this.selectByQuery("SELECT * FROM public.book ORDER BY book_id");
    }

    // Method to execute a select query and return a list of books
    public ArrayList<Book> selectByQuery(String query) {
        ArrayList<Book> books = new ArrayList<>();
        try {
            ResultSet rs = this.connection.createStatement().executeQuery(query);
            // Iterate through the result set and add each book to the list
            while (rs.next()) {
                books.add(this.match(rs)); // Convert ResultSet to Book object and add to the list
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if an SQLException occurs
        }
        return books; // Return the list of books
    }

    // Method to save a book to the database
    public boolean save(Book book) {
        String query = "INSERT INTO public.book " +
                "(" +
                "book_car_id, " +
                "book_name, " +
                "book_idno, " +
                "book_mpno, " +
                "book_mail, " +
                "book_strt_date," +
                "book_fnsh_date, " +
                "book_prc, " +
                "book_case, " +
                "book_note" +
                ")" +
                "VALUES(?,?,?,?,?,?,?,?,?,?)"; // SQL query to insert a new book
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            // Set values for parameters in the prepared statement
            ps.setInt(1, book.getCar_id());
            ps.setString(2, book.getName());
            ps.setString(3, book.getIdno());
            ps.setString(4, book.getMpno());
            ps.setString(5, book.getMail());
            ps.setDate(6, Date.valueOf(book.getStrt_date()));
            ps.setDate(7, Date.valueOf(book.getFnsh_date()));
            ps.setInt(8, book.getPrc());
            ps.setString(9, book.getbCase());
            ps.setString(10, book.getNote());
            // Execute the update and return true if successful
            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if an SQLException occurs
        }
        return true; // Return true by default
    }

    // Method to convert a ResultSet to a Book object
    public Book match(ResultSet rs) throws SQLException {
        Book book = new Book();
        // Set attributes of the book object using data from the ResultSet
        book.setId(rs.getInt("book_id"));
        book.setbCase(rs.getString("book_case"));
        book.setCar_id(rs.getInt("book_car_id"));
        book.setName(rs.getString("book_name"));
        book.setStrt_date(LocalDate.parse(rs.getString("book_strt_date")));
        book.setFnsh_date(LocalDate.parse(rs.getString("book_fnsh_date")));
        book.setCar(this.carDao.getById(rs.getInt("book_car_id"))); // Get car details using CarDao
        book.setIdno(rs.getString("book_idno"));
        book.setMpno(rs.getString("book_mpno"));
        book.setMail(rs.getString("book_mail"));
        book.setNote(rs.getString("book_note"));
        book.setPrc(rs.getInt("book_prc"));
        return book; // Return the Book object
    }

    // Method to retrieve a book by its ID
    public Book getById(int id) {
        Book obj = null;
        String query = "SELECT * FROM public.book WHERE book_id = ?"; // SQL query to select a book by ID
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                obj = this.match(rs); // Convert ResultSet to Book object
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace if an exception occurs
        }
        return obj; // Return the Book object
    }

    // Method to delete a book by its ID
    public boolean delete(int id) {
        String query = "DELETE FROM public.book WHERE book_id = ?"; // SQL query to delete a book by ID
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setInt(1, id);
            // Execute the update and return true if successful
            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if an SQLException occurs
        }
        return true; // Return true by default
    }
}
