package raven.webpos.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import raven.webpos.infrastructure.model.request.BaseRequest;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequest implements BaseRequest {

    @NotBlank(message = "Name is required")
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String description;
}
