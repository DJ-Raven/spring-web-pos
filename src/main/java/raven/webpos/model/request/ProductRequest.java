package raven.webpos.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import raven.webpos.infrastructure.model.request.BaseRequest;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest implements BaseRequest {

    private String code;

    @NotBlank(message = "Name is required")
    private String name;

    @Positive(message = "Price must be a positive value")
    private BigDecimal price;

    @NotNull(message = "Category is required")
    private Integer categoryId;

    private List<String> images;
}
