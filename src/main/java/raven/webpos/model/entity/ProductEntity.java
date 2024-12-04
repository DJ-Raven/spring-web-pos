package raven.webpos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import raven.webpos.infrastructure.model.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity<Integer> {

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    private BigDecimal price;
    private int qtyStock;
    private BigDecimal cost;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<ProductImageEntity> images;
}
