package raven.webpos.repository;

import org.springframework.stereotype.Repository;
import raven.webpos.infrastructure.repository.BaseRepository;
import raven.webpos.model.entity.CategoryEntity;

@Repository
public interface CategoryRepository extends BaseRepository<CategoryEntity, Integer> {
}
