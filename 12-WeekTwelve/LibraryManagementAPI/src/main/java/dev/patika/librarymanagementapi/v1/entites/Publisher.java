package dev.patika.librarymanagementapi.v1.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id",columnDefinition = "serial")
    private long id;

    @Column(name = "publisher_name",nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "publisher_build_year",nullable = false)
    private LocalDate year;

    @Column(name = "publisher_address",nullable = false)
    private String address;

    @OneToMany(mappedBy = "publisher",cascade = CascadeType.REMOVE)
    private List<Book> bookList;
}
