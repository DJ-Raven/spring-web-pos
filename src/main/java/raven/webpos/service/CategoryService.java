package raven.webpos.service;

import org.springframework.stereotype.Service;
import raven.webpos.infrastructure.service.AbstractBaseService;
import raven.webpos.model.entity.CategoryEntity;
import raven.webpos.model.mapper.CategoryMapper;
import raven.webpos.repository.CategoryRepository;
import raven.webpos.validator.RequestValidator;

@Service
public class CategoryService extends AbstractBaseService<CategoryEntity, Integer> {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    public CategoryService(CategoryRepository repository, CategoryMapper mapper, RequestValidator validator) {
        super(repository, mapper, validator);
        this.repository = repository;
        this.mapper = mapper;
    }
}
