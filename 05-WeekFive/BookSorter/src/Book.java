import java.util.Comparator;
import java.lang.String;
public class Book implements Comparable<Book> {
    private String bookName;   // The name of the book.
    private int pageNumber;    // The number of pages in the book.
    private String authorName; // The name of the author of the book.
    private int publishDate;   // The year the book was published.
    private int ID;            // The unique identifier of the book.


    // Constructor to initialize a Book object with provided attributes.
    public Book(int ID,String bookName, int pageNumber, String authorName, int publishDate) {
        this.bookName = bookName;
        this.pageNumber = pageNumber;
        this.authorName = authorName;
        this.publishDate = publishDate;
        this.ID = ID;
    }

    // Implementation of the compareTo method from the Comparable interface to compare books by their names.
    @Override
    public int compareTo(Book o){
        return this.bookName.compareTo(o.bookName);
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(int publishDate) {
        this.publishDate = publishDate;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
