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
public class CustomerResponse implements BaseResponse {

    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String description;
}
