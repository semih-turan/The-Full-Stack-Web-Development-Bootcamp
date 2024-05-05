package dev.patika.librarymanagementapi.v1.business.abstracts;

import dev.patika.librarymanagementapi.v1.entites.Category;
import org.springframework.data.domain.Page;

public interface CategoryService {
    Category save(Category category);
    Category update(Category category);
    Category getId(long id);
    Page<Category> cursor(int page, int pageSize);
    boolean delete(long id);
}
