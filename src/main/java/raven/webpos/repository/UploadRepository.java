package raven.webpos.repository;

import org.springframework.stereotype.Repository;
import raven.webpos.infrastructure.repository.BaseRepository;
import raven.webpos.model.entity.UploadEntity;

import java.util.UUID;

@Repository
public interface UploadRepository extends BaseRepository<UploadEntity, UUID> {
}
