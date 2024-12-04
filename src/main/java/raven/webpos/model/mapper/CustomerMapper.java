package raven.webpos.model.mapper;

import org.springframework.stereotype.Component;
import raven.webpos.infrastructure.model.mapper.BaseMapper;
import raven.webpos.model.entity.CustomerEntity;
import raven.webpos.model.request.CustomerRequest;
import raven.webpos.model.response.CustomerResponse;

@Component
public class CustomerMapper implements BaseMapper<CustomerEntity, CustomerRequest, CustomerResponse> {

    @Override
    public CustomerEntity toEntity(CustomerRequest request) {
        return CustomerEntity.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .address(request.getAddress())
                .description(request.getDescription())
                .build();
    }

    @Override
    public CustomerEntity toEntityUpdate(CustomerEntity customerEntity, CustomerRequest request) {
        customerEntity.setName(request.getName());
        customerEntity.setEmail(request.getEmail());
        customerEntity.setPhoneNumber(request.getPhoneNumber());
        customerEntity.setDescription(request.getDescription());
        return customerEntity;
    }

    @Override
    public CustomerResponse toResponse(CustomerEntity entity) {
        return CustomerResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .address(entity.getAddress())
                .description(entity.getDescription())
                .build();
    }

    @Override
    public CustomerResponse toResponseCreate(CustomerEntity entity) {
        return CustomerResponse.builder()
                .id(entity.getId())
                .build();
    }
}
