package raven.webpos.model.mapper;

import org.springframework.stereotype.Component;
import raven.webpos.infrastructure.model.mapper.BaseMapper;
import raven.webpos.model.entity.ProductEntity;
import raven.webpos.model.entity.ProductImageEntity;
import raven.webpos.model.request.ProductImageRequest;
import raven.webpos.model.response.ProductImageResponse;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductImageMapper implements BaseMapper<ProductImageEntity, ProductImageRequest, ProductImageResponse> {

    @Override
    public ProductImageEntity toEntity(ProductImageRequest request) {
        return ProductImageEntity.builder()
                .image(request.getImage())
                .product(ProductEntity.builder()
                        .id(request.getProductId())
                        .build())
                .build();
    }

    @Override
    public ProductImageEntity toEntityUpdate(ProductImageEntity productImageEntity, ProductImageRequest request) {
        return null;
    }

    @Override
    public ProductImageResponse toResponse(ProductImageEntity entity) {
        return ProductImageResponse.builder()
                .id(entity.getId())
                .image(entity.getImage())
                .build();
    }

    @Override
    public ProductImageResponse toResponseCreate(ProductImageEntity entity) {
        return ProductImageResponse.builder()
                .id(entity.getId())
                .build();
    }

    public List<ProductImageEntity> toEntity(List<String> images) {
        return images.stream()
                .map(image -> ProductImageEntity.builder()
                        .image(image)
                        .build())
                .collect(Collectors.toList());
    }

    public List<ProductImageResponse> toResponse(List<ProductImageEntity> entities) {
        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public List<ProductImageResponse> toResponseCreate(List<ProductImageEntity> entities) {
        return entities.stream()
                .map(this::toResponseCreate)
                .collect(Collectors.toList());
    }

    public List<ProductImageEntity> verifyProduct(List<ProductImageEntity> entities, Integer id) {
        ProductEntity product = ProductEntity.builder()
                .id(id)
                .build();
        entities.forEach(entity -> {
            entity.setProduct(product);
        });
        return entities;
    }
}
