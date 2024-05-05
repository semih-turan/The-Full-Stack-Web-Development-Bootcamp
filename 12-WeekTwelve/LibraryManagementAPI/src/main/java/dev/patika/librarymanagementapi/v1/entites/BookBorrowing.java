package dev.patika.librarymanagementapi.v1.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="book_borrowings")
public class BookBorrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id",columnDefinition = "serial")
    private long id;

    @Column(name = "borrow_name",nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "borrow_date",nullable = false)
    private LocalDate date;

    @Column(name = "book_borrowing_mail")
    @Email
    private String mail;

    @Temporal(TemporalType.DATE)
    @Column(name = "borrow_re_date")
    private LocalDate reDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "borrow_book_id",referencedColumnName = "book_id")
    private Book book;
}
