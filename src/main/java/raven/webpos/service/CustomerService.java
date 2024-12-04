package raven.webpos.service;

import org.springframework.stereotype.Service;
import raven.webpos.infrastructure.service.AbstractBaseService;
import raven.webpos.model.entity.CustomerEntity;
import raven.webpos.model.mapper.CustomerMapper;
import raven.webpos.repository.CustomerRepository;
import raven.webpos.validator.RequestValidator;

@Service
public class CustomerService extends AbstractBaseService<CustomerEntity, Integer> {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public CustomerService(CustomerRepository repository, CustomerMapper mapper, RequestValidator validator) {
        super(repository, mapper, validator);
        this.repository = repository;
        this.mapper = mapper;
    }
}
