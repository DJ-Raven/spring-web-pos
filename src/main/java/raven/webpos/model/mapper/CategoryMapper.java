package raven.webpos.model.mapper;

import org.springframework.stereotype.Component;
import raven.webpos.infrastructure.model.mapper.BaseMapper;
import raven.webpos.model.entity.CategoryEntity;
import raven.webpos.model.request.CategoryRequest;
import raven.webpos.model.response.CategoryResponse;

@Component
public class CategoryMapper implements BaseMapper<CategoryEntity, CategoryRequest, CategoryResponse> {

    @Override
    public CategoryEntity toEntity(CategoryRequest request) {
        return CategoryEntity.builder()
                .name(request.getName())
                .build();
    }

    @Override
    public CategoryEntity toEntityUpdate(CategoryEntity categoryEntity, CategoryRequest request) {
        categoryEntity.setName(request.getName());
        return categoryEntity;
    }

    @Override
    public CategoryResponse toResponse(CategoryEntity entity) {
        return CategoryResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    @Override
    public CategoryResponse toResponseCreate(CategoryEntity entity) {
        return CategoryResponse.builder()
                .id(entity.getId())
                .build();
    }
}
