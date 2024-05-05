package dev.patika.librarymanagementapi.v1.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id",columnDefinition = "serial")
    private long id;

    @Column(name = "book_name",nullable = false)
    private String name;

    @Column(name = "book_year",nullable = false)
    private int year;

    @Column(name = "book_stock",nullable = false)
    private int stock;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_author_id",referencedColumnName = "author_id")
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_publisher_id",referencedColumnName = "publisher_id")
    private Publisher publisher;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JoinTable(name = "book_category",joinColumns = {@JoinColumn(name = "book_category_book_id")},inverseJoinColumns = {@JoinColumn(name = "book_category_category_id")})
    private List<Category> categories;

    @OneToMany(mappedBy = "")
    private List<BookBorrowing> bookBorrowingList;

}
