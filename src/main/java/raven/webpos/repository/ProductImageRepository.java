package raven.webpos.repository;

import org.springframework.stereotype.Repository;
import raven.webpos.infrastructure.repository.BaseRepository;
import raven.webpos.model.entity.ProductImageEntity;

@Repository
public interface ProductImageRepository extends BaseRepository<ProductImageEntity, Integer> {
}
