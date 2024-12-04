package raven.webpos.infrastructure.service;

import jakarta.persistence.EntityNotFoundException;
import raven.webpos.infrastructure.model.entity.BaseEntity;
import raven.webpos.infrastructure.model.mapper.BaseMapper;
import raven.webpos.infrastructure.model.request.BaseRequest;
import raven.webpos.infrastructure.model.response.BaseResponse;
import raven.webpos.infrastructure.repository.BaseRepository;
import raven.webpos.validator.RequestValidator;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractBaseService<T extends BaseEntity, ID extends Serializable> implements BaseService<ID> {

    private final BaseRepository<T, ID> repository;
    private final BaseMapper<T, BaseRequest, BaseResponse> mapper;
    private final RequestValidator validator;

    public AbstractBaseService(BaseRepository<T, ID> repository, BaseMapper mapper, RequestValidator validator) {
        this.repository = repository;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public List<BaseResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BaseResponse findById(ID id) {
        return repository.findByIdAndDeletedDateIsNull(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("No data fount with the ID: " + id));
    }

    @Override
    public BaseResponse create(BaseRequest request) {
        validator.validate(request);
        var entity = mapper.toEntity(request);
        repository.save(entity);
        return mapper.toResponseCreate(entity);
    }

    @Override
    public void update(BaseRequest request, ID id) {
        validator.validate(request);
        var entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No data fount with the ID: " + id));
        repository.save(mapper.toEntityUpdate(entity, request));
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }
}
