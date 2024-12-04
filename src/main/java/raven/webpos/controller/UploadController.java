package raven.webpos.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import raven.webpos.infrastructure.model.response.BaseResponse;
import raven.webpos.model.request.UploadRequest;
import raven.webpos.model.response.UploadResponse;
import raven.webpos.service.UploadService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/upload")
public class UploadController {

    private final UploadService uploadService;

    @GetMapping
    public ResponseEntity<List<BaseResponse>> findAll() {
        return ResponseEntity.ok(uploadService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<byte[]> findById(@PathVariable UUID id) {
        UploadResponse response = (UploadResponse) uploadService.findById(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(response.getFileType()))
                .body(response.getData());
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@ModelAttribute UploadRequest request) {
        return ResponseEntity.ok(uploadService.create(request));
    }
}
