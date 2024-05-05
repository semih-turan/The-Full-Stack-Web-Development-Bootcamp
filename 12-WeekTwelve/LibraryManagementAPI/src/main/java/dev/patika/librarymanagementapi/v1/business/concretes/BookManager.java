package dev.patika.librarymanagementapi.v1.business.concretes;

import dev.patika.librarymanagementapi.v1.business.abstracts.BookService;
import dev.patika.librarymanagementapi.v1.core.exception.NotFoundException;
import dev.patika.librarymanagementapi.v1.core.utils.Message;
import dev.patika.librarymanagementapi.v1.dao.BookRepository;
import dev.patika.librarymanagementapi.v1.entites.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookManager implements BookService {

    private final BookRepository bookRepository;
    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        getId(book.getId());
        return bookRepository.save(book);
    }

    @Override
    public Book getId(long id) {
        return bookRepository.findById(id).orElseThrow(()-> new NotFoundException(Message.NOT_FOUND));
    }

    @Override
    public Page<Book> cursor(int page, int pageSize) {
        return bookRepository.findAll(PageRequest.of(page,pageSize));
    }

    @Override
    public boolean delete(long id) {
        bookRepository.delete(getId(id));
        return true;
    }
}
