package dev.patika.librarymanagementapi.v1.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="author_id", columnDefinition = "serial")
    private long id;

    @Column(name = "author_name",nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "author_birthday",nullable = false)
    private LocalDate year;

    @Column(name = "author_country",nullable = false)
    private String country;

    @OneToMany(mappedBy = "author",cascade = CascadeType.REMOVE)
    private List<Book> bookList;

}
