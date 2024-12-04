package raven.webpos.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import raven.webpos.infrastructure.model.entity.BaseEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity<Integer> {

    @Column(nullable = false)
    private String name;

    private String email;
    private String phoneNumber;
    private String address;
    private String description;
}
