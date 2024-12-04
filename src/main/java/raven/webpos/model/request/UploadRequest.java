package raven.webpos.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import raven.webpos.infrastructure.model.request.BaseRequest;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UploadRequest implements BaseRequest {

    private MultipartFile file;
}
