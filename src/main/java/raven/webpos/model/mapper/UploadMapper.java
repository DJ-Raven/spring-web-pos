package raven.webpos.model.mapper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import raven.webpos.infrastructure.model.mapper.BaseMapper;
import raven.webpos.model.entity.UploadEntity;
import raven.webpos.model.request.UploadRequest;
import raven.webpos.model.response.UploadResponse;

import java.io.IOException;

@Component
public class UploadMapper implements BaseMapper<UploadEntity, UploadRequest, UploadResponse> {

    @Override
    public UploadEntity toEntity(UploadRequest request) {
        try {
            MultipartFile file = request.getFile();
            return UploadEntity.builder()
                    .fileType(file.getContentType())
                    .data(file.getBytes())
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public UploadEntity toEntityUpdate(UploadEntity uploadEntity, UploadRequest request) {
        return null;
    }

    @Override
    public UploadResponse toResponse(UploadEntity entity) {
        return UploadResponse.builder()
                .id(entity.getId())
                .fileType(entity.getFileType())
                .data(entity.getData())
                .build();
    }

    @Override
    public UploadResponse toResponseCreate(UploadEntity entity) {
        return UploadResponse.builder()
                .id(entity.getId())
                .fileType(entity.getFileType())
                .build();
    }
}
