package raven.webpos.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import raven.webpos.infrastructure.model.response.BaseResponse;
import raven.webpos.model.request.CategoryRequest;
import raven.webpos.service.CategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<BaseResponse>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CategoryRequest request) {
        return ResponseEntity.ok(categoryService.create(request));
    }

    @PutMapping("{id}")
    public void update(@RequestBody CategoryRequest request, @PathVariable Integer id) {
        categoryService.update(request, id);
    }
}
