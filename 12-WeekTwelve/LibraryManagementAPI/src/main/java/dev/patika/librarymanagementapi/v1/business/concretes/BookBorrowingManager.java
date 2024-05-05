package dev.patika.librarymanagementapi.v1.business.concretes;

import dev.patika.librarymanagementapi.v1.business.abstracts.BookBorrowingService;
import dev.patika.librarymanagementapi.v1.core.exception.NotFoundException;
import dev.patika.librarymanagementapi.v1.core.utils.Message;
import dev.patika.librarymanagementapi.v1.dao.BookBorrowingRepository;
import dev.patika.librarymanagementapi.v1.entites.BookBorrowing;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookBorrowingManager implements BookBorrowingService {
    private final BookBorrowingRepository bookBorrowingRepository;
    @Override
    public BookBorrowing save(BookBorrowing bookBorrowing) {
        return bookBorrowingRepository.save(bookBorrowing);
    }

    @Override
    public BookBorrowing update(BookBorrowing bookBorrowing) {
        getId(bookBorrowing.getId());
        return bookBorrowingRepository.save(bookBorrowing);
    }

    @Override
    public BookBorrowing getId(long id) {
        return bookBorrowingRepository.findById(id).orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));
    }

    @Override
    public Page<BookBorrowing> cursor(int page, int pageSize) {
        return bookBorrowingRepository.findAll(PageRequest.of(page,pageSize));
    }

    @Override
    public boolean delete(long id) {
        bookBorrowingRepository.delete(getId(id));
        return true;
    }
}
