package dev.patika.librarymanagementapi.v1.business.abstracts;

import dev.patika.librarymanagementapi.v1.entites.BookBorrowing;
import org.springframework.data.domain.Page;

public interface BookBorrowingService {
    BookBorrowing getId(long id);
    BookBorrowing save(BookBorrowing bookBorrowing);
    BookBorrowing update(BookBorrowing bookBorrowing);
    Page<BookBorrowing> cursor(int page, int pageSize);
    boolean delete(long id);
}
