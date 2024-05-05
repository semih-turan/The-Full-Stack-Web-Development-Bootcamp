package dev.patika.librarymanagementapi.v1.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id",columnDefinition = "serial")
    private long id;

    @Column(name = "category_name",nullable = false)
    private String name;

    @Column(name = "category_description",nullable = false)
    private String description;

    @ManyToMany(mappedBy = "categories",cascade = CascadeType.REMOVE)
    private List<Book> bookList;
}
