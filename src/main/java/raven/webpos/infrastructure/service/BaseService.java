package raven.webpos.infrastructure.service;

import raven.webpos.infrastructure.model.request.BaseRequest;
import raven.webpos.infrastructure.model.response.BaseResponse;

import java.io.Serializable;
import java.util.List;

public interface BaseService<ID extends Serializable> {

    List<BaseResponse> findAll();

    BaseResponse findById(ID id);

    BaseResponse create(BaseRequest request);

    void update(BaseRequest request, ID id);

    void delete(ID id);
}
