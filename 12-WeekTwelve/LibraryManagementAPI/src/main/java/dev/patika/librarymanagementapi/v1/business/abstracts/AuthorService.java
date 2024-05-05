package dev.patika.librarymanagementapi.v1.business.abstracts;

import dev.patika.librarymanagementapi.v1.entites.Author;
import org.springframework.data.domain.Page;

public interface AuthorService {
    Author getId(long id);
    Author save(Author author);
    Author update(Author author);
    Page<Author> cursor(int page, int pageSize);
    boolean delete(long id);
}
