/**
 * @author Semih Turan
 * @since march 2024
 */
import java.util.Comparator;
import java.util.TreeSet;
public class Main {
    public static void main(String[] args) {
        // Create a TreeSet to store books
        TreeSet<Book> books = new TreeSet<>();

        // Create book objects
        Book book1 = new Book(1,"Thinking, Fast and Slow",499,"Daniel Kahneman", 2011);
        Book book2 = new Book(2,"I Flew for the Führer",192,"Heinz Knoke", 1952);
        Book book3 = new Book(3,"Mayday",480,"Nelson DeMille",1979);
        Book book4 = new Book(4,"No Easy Day",316,"Mark Owen", 2012);
        Book book5 = new Book(5,"Life Under Fire",296,"Jason Fox",2020);

        // Add books to the TreeSet
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        // Sort books by book name and print them to the console
        System.out.println("Books sorted by book name...");
        System.out.printf("%3s %-24s %-10s %-15s %-11s\n","#ID", "Name","PageNumber", "Author","PublishDate");

        for(Book book : books){
            System.out.printf("%3d %-24s %-10d %-15s %-11s\n",book.getID(),book.getBookName(),
                    book.getPageNumber(),book.getAuthorName(), book.getPublishDate());
        }

        // Create a TreeSet to sort books by page number
        TreeSet<Book> bookSortedByPageNumber = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPageNumber()-o2.getPageNumber();
            }
        });

        // Add books to the TreeSet
        bookSortedByPageNumber.add(book1);
        bookSortedByPageNumber.add(book2);
        bookSortedByPageNumber.add(book3);
        bookSortedByPageNumber.add(book4);
        bookSortedByPageNumber.add(book5);

        // Sort books by page number and print them to the console
        System.out.println();
        System.out.println("Books sorted by page number...");
        System.out.printf("%3s %-24s %-10s %-15s %-11s\n","#ID", "Name","PageNumber", "Author","PublishDate");
        for(Book book : bookSortedByPageNumber.reversed()){
            System.out.printf("%3d %-24s %-10d %-15s %-11s\n",book.getID(),book.getBookName(),
                    book.getPageNumber(),book.getAuthorName(), book.getPublishDate());
        }
    }
}