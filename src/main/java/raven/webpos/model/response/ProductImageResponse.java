package raven.webpos.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import raven.webpos.infrastructure.model.response.BaseResponse;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductImageResponse implements BaseResponse {

    private Integer id;
    private String image;
}
