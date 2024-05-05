package dev.patika.librarymanagementapi.v1.business.concretes;

import dev.patika.librarymanagementapi.v1.business.abstracts.CategoryService;
import dev.patika.librarymanagementapi.v1.core.exception.NotFoundException;
import dev.patika.librarymanagementapi.v1.core.utils.Message;
import dev.patika.librarymanagementapi.v1.dao.CategoryRepository;
import dev.patika.librarymanagementapi.v1.entites.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryManager implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        getId(category.getId());
        return categoryRepository.save(category);
    }

    @Override
    public Category getId(long id) {
        return categoryRepository.findById(id).orElseThrow(()-> new NotFoundException(Message.NOT_FOUND));
    }

    @Override
    public Page<Category> cursor(int page, int pageSize) {
        return categoryRepository.findAll(PageRequest.of(page,pageSize));
    }

    @Override
    public boolean delete(long id) {
        categoryRepository.delete(getId(id));
        return true;
    }
}
