package raven.webpos.repository;

import org.springframework.stereotype.Repository;
import raven.webpos.infrastructure.repository.BaseRepository;
import raven.webpos.model.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends BaseRepository<CustomerEntity, Integer> {
}
