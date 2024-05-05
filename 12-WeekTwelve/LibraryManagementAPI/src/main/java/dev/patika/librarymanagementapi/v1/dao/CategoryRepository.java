package dev.patika.librarymanagementapi.v1.dao;

import dev.patika.librarymanagementapi.v1.entites.Author;
import dev.patika.librarymanagementapi.v1.entites.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
