package raven.webpos.infrastructure.model.mapper;

import raven.webpos.infrastructure.model.entity.BaseEntity;
import raven.webpos.infrastructure.model.request.BaseRequest;
import raven.webpos.infrastructure.model.response.BaseResponse;

public interface BaseMapper<T extends BaseEntity, RQ extends BaseRequest, RS extends BaseResponse> {
    T toEntity(RQ request);

    T toEntityUpdate(T t, RQ request);

    RS toResponse(T entity);

    RS toResponseCreate(T entity);
}
