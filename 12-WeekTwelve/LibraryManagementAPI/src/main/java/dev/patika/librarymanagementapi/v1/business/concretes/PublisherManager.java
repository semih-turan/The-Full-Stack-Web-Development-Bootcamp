package dev.patika.librarymanagementapi.v1.business.concretes;

import dev.patika.librarymanagementapi.v1.business.abstracts.PublisherService;
import dev.patika.librarymanagementapi.v1.core.exception.NotFoundException;
import dev.patika.librarymanagementapi.v1.core.utils.Message;
import dev.patika.librarymanagementapi.v1.dao.PublisherRepository;
import dev.patika.librarymanagementapi.v1.entites.Publisher;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublisherManager implements PublisherService {
    private final PublisherRepository publisherRepository;
    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher update(Publisher publisher) {
        getId(publisher.getId());
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher getId(long id) {
        return publisherRepository.findById(id).orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));
    }

    @Override
    public Page<Publisher> cursor(int page, int pageSize) {
        return publisherRepository.findAll(PageRequest.of(page,pageSize));
    }

    @Override
    public boolean delete(long id) {
        publisherRepository.delete(getId(id));
        return true;
    }
}
