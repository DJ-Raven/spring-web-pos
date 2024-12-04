package raven.webpos.model.entity;

import jakarta.persistence.*;
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
@Table(name = "product_image")
public class ProductImageEntity extends BaseEntity<Integer> {

    @Column(nullable = false)
    private String image;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;
}
