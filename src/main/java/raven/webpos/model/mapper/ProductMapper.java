package raven.webpos.model.mapper;

import org.springframework.stereotype.Component;
import raven.webpos.infrastructure.model.mapper.BaseMapper;
import raven.webpos.model.entity.CategoryEntity;
import raven.webpos.model.entity.ProductEntity;
import raven.webpos.model.request.ProductRequest;
import raven.webpos.model.response.ProductResponse;

import java.math.BigDecimal;

@Component
public class ProductMapper implements BaseMapper<ProductEntity, ProductRequest, ProductResponse> {

    private final CategoryMapper categoryMapper;
    private final ProductImageMapper imageMapper;

    public ProductMapper(CategoryMapper categoryMapper, ProductImageMapper imageMapper) {
        this.categoryMapper = categoryMapper;
        this.imageMapper = imageMapper;
    }

    @Override
    public ProductEntity toEntity(ProductRequest request) {
        return ProductEntity.builder()
                .code(request.getCode())
                .name(request.getName())
                .price(request.getPrice())
                .qtyStock(0)
                .cost(BigDecimal.ZERO)
                .category(CategoryEntity.builder()
                        .id(request.getCategoryId())
                        .build())
                .images(imageMapper.toEntity(request.getImages()))
                .build();
    }

    @Override
    public ProductEntity toEntityUpdate(ProductEntity productEntity, ProductRequest request) {
        productEntity.setCode(request.getCode());
        productEntity.setName(request.getName());
        productEntity.setPrice(request.getPrice());
        productEntity.getCategory().setId(request.getCategoryId());

        return productEntity;
    }

    @Override
    public ProductResponse toResponse(ProductEntity entity) {
        return ProductResponse.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .price(entity.getPrice())
                .category(categoryMapper.toResponse(entity.getCategory()))
                .images(imageMapper.toResponse(entity.getImages()))
                .build();
    }

    @Override
    public ProductResponse toResponseCreate(ProductEntity entity) {
        return ProductResponse.builder()
                .id(entity.getId())
                .images(imageMapper.toResponseCreate(entity.getImages()))
                .build();
    }

    public CategoryMapper getCategoryMapper() {
        return categoryMapper;
    }

    public ProductImageMapper getImageMapper() {
        return imageMapper;
    }
}
