package dev.patika.librarymanagementapi.v1.business.abstracts;

import dev.patika.librarymanagementapi.v1.entites.Book;
import org.springframework.data.domain.Page;

public interface BookService {
    Book save(Book Book);
    Book update(Book Book);
    Book getId(long id);
    Page<Book> cursor(int page, int pageSize);
    boolean delete(long id);
}
