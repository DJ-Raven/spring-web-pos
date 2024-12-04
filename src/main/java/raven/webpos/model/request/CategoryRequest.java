package raven.webpos.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import raven.webpos.infrastructure.model.request.BaseRequest;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryRequest implements BaseRequest {

    @NotBlank(message = "Name is required")
    private String name;
}
