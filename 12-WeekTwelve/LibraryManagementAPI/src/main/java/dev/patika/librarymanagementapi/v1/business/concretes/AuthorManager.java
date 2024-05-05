package dev.patika.librarymanagementapi.v1.business.concretes;

import dev.patika.librarymanagementapi.v1.core.utils.Message;
import dev.patika.librarymanagementapi.v1.business.abstracts.AuthorService;
import dev.patika.librarymanagementapi.v1.core.exception.NotFoundException;
import dev.patika.librarymanagementapi.v1.dao.AuthorRepository;
import dev.patika.librarymanagementapi.v1.entites.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorManager implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public Author getId(long id) {
        return authorRepository.findById(id).orElseThrow(()-> new NotFoundException(Message.NOT_FOUND));
    }

    @Override
    public Author save(Author author) {
        return this.authorRepository.save(author);
    }

    @Override
    public Author update(Author author) {
        this.getId(author.getId());
        return this.authorRepository.save(author);
    }

    @Override
    public Page<Author> cursor(int page, int pageSize) {
        return authorRepository.findAll(PageRequest.of(page, pageSize));
    }

    @Override
    public boolean delete(long id) {
        this.authorRepository.delete(getId(id));
        return true;
    }
}
