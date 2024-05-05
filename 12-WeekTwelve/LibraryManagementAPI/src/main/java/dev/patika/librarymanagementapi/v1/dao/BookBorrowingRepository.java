package dev.patika.librarymanagementapi.v1.dao;

import dev.patika.librarymanagementapi.v1.entites.BookBorrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookBorrowingRepository extends JpaRepository<BookBorrowing, Long> {
}
