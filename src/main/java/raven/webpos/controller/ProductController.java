package raven.webpos.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import raven.webpos.infrastructure.model.response.BaseResponse;
import raven.webpos.model.request.ProductRequest;
import raven.webpos.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<BaseResponse>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody ProductRequest request) {
        return ResponseEntity.ok(productService.create(request));
    }

    @PutMapping("{id}")
    public void update(@RequestBody ProductRequest request, @PathVariable Integer id) {
        productService.update(request, id);
    }
}
