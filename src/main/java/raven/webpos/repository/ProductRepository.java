package raven.webpos.repository;

import org.springframework.stereotype.Repository;
import raven.webpos.infrastructure.repository.BaseRepository;
import raven.webpos.model.entity.ProductEntity;

@Repository
public interface ProductRepository extends BaseRepository<ProductEntity, Integer> {
}
