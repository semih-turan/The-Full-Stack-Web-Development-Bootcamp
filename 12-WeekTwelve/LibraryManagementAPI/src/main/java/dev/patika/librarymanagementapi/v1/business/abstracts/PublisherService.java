package dev.patika.librarymanagementapi.v1.business.abstracts;

import dev.patika.librarymanagementapi.v1.entites.Publisher;
import org.springframework.data.domain.Page;

public interface PublisherService {
    Publisher save(Publisher publisher);
    Publisher update(Publisher publisher);
    Publisher getId(long id);
    Page<Publisher> cursor(int page, int pageSize);
    boolean delete(long id);
}
