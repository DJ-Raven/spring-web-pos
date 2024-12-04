package raven.webpos.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import raven.webpos.infrastructure.model.response.BaseResponse;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse implements BaseResponse {

    private Integer id;
    private String code;
    private String name;
    private BigDecimal price;
    private CategoryResponse category;
    private List<ProductImageResponse> images;
}
