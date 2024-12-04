package raven.webpos.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import raven.webpos.infrastructure.model.response.BaseResponse;
import raven.webpos.infrastructure.service.AbstractBaseService;
import raven.webpos.model.entity.UploadEntity;
import raven.webpos.model.mapper.UploadMapper;
import raven.webpos.repository.UploadRepository;
import raven.webpos.validator.RequestValidator;

import java.util.UUID;

@Service
public class UploadService extends AbstractBaseService<UploadEntity, UUID> {

    private final UploadRepository repository;
    private final UploadMapper mapper;

    public UploadService(UploadRepository repository, UploadMapper mapper, RequestValidator validator) {
        super(repository, mapper, validator);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public BaseResponse findById(UUID uuid) {
        return super.findById(uuid);
    }
}
