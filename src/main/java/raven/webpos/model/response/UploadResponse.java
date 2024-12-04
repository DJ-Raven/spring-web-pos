package raven.webpos.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import raven.webpos.infrastructure.model.response.BaseResponse;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UploadResponse implements BaseResponse {

    private UUID id;
    private String fileType;
    private byte[] data;
}
