package dev.patika.librarymanagementapi.v1.dao;

import dev.patika.librarymanagementapi.v1.entites.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
