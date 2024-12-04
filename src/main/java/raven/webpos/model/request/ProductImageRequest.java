package raven.webpos.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import raven.webpos.infrastructure.model.request.BaseRequest;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductImageRequest implements BaseRequest {

    @NotBlank(message = "Image is required")
    private String image;

    @NotNull(message = "Product is required")
    private Integer productId;
}
