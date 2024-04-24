package dev.patika;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="book_borrowings")
public class BookBorrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_borrowing_id", columnDefinition = "serial")
    private long id;

    @Column(name="book_borrowing_borrower_name", nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name="book_borrowing_date",nullable = false)
    LocalDate borrowingDate;

    @Temporal(TemporalType.DATE)
    @Column(name="book_borrowing_return_date",nullable = false)
    LocalDate returnDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "borrow_book_id",referencedColumnName = "book_id")
    private Book book;

    public BookBorrowing() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(LocalDate borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "BookBorrowing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", borrowingDate=" + borrowingDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
