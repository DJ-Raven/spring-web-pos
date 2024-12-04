package raven.webpos.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import raven.webpos.infrastructure.model.request.BaseRequest;
import raven.webpos.infrastructure.model.response.BaseResponse;
import raven.webpos.infrastructure.service.AbstractBaseService;
import raven.webpos.model.entity.ProductEntity;
import raven.webpos.model.mapper.ProductMapper;
import raven.webpos.model.request.ProductRequest;
import raven.webpos.repository.ProductImageRepository;
import raven.webpos.repository.ProductRepository;
import raven.webpos.validator.RequestValidator;

@Service
public class ProductService extends AbstractBaseService<ProductEntity, Integer> {

    private final ProductRepository repository;
    private final ProductImageRepository imageRepository;
    private final ProductMapper mapper;
    private final RequestValidator validator;

    public ProductService(ProductRepository repository, ProductImageRepository imageRepository, ProductMapper mapper, RequestValidator validator) {
        super(repository, mapper, validator);
        this.repository = repository;
        this.imageRepository = imageRepository;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public BaseResponse create(BaseRequest request) {
        validator.validate(request);
        ProductRequest productRequest = (ProductRequest) request;
        var entity = mapper.toEntity(productRequest);
        repository.save(entity);
        imageRepository.saveAll(mapper.getImageMapper().verifyProduct(entity.getImages(), entity.getId()));
        return mapper.toResponseCreate(entity);
    }
}
