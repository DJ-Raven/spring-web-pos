package raven.webpos.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import raven.webpos.infrastructure.model.entity.BaseEntity;

import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID extends Serializable> extends JpaRepository<T, ID> {

    Optional<T> findByIdAndDeletedDateIsNull(ID id);
}
