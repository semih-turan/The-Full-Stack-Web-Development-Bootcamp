package business;

import core.Helper;
import dao.BookDao;
import entity.Book;

import java.util.ArrayList;

public class BookManager {

    private BookDao bookDao;

    // BookManager constructor initializes the BookDao instance
    public BookManager() {
        this.bookDao = new BookDao();
    }

    // Method to save a book into the database
    public boolean save(Book book) {
        return this.bookDao.save(book);
    }

    // Method to delete a book from the database by its ID
    public boolean delete(int id) {
        // Check if the book with the given ID exists
        if (this.getById(id) == null) {
            Helper.showMessage(id + " ID Kayıtlı araç bulunamadı."); // Display message if book is not found
            return false; // Return false indicating deletion failure
        }
        // Delete the book from the database using the BookDao instance
        return this.bookDao.delete(id);
    }

    // Method to get a book by its ID
    public Book getById(int id) {
        return this.bookDao.getById(id); // Retrieve the book using BookDao instance
    }

    // Method to find all books in the database
    public ArrayList<Book> findAll() {
        return this.bookDao.findAll(); // Retrieve all books using BookDao instance
    }

    // Method to prepare data for a table view
    public ArrayList<Object[]> getForTable(int size, ArrayList<Book> books) {
        ArrayList<Object[]> bookList = new ArrayList<>();
        for (Book obj : books) {
            int i = 0;
            Object[] rowObject = new Object[size];
            // Populate the rowObject with book information
            rowObject[i++] = obj.getId(); // Add book ID to rowObject
            // Add other properties of the Book class here
            // For example: rowObject[i++] = obj.getSomeProperty();
            bookList.add(rowObject); // Add rowObject to bookList
        }
        return bookList; // Return the list of row objects
    }

    // Method to search for books in the database for table view based on car ID
    public ArrayList<Book> searchForTable(int carId) {
        String select = "SELECT * FROM public.book";
        ArrayList<String> whereList = new ArrayList<>();

        // Check if carId is provided for filtering
        if (carId != 0) {
            whereList.add("book_car_id = " + carId); // Add car ID condition to whereList
        }

        String whereStr = String.join(" AND ", whereList); // Join where conditions with 'AND' operator
        String query = select;
        if (!whereStr.isEmpty()) {
            query += " WHERE " + whereStr; // Append where conditions to the query
        }

        return this.bookDao.selectByQuery(query); // Execute the constructed query using BookDao instance
    }
}
