package raven.webpos.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import raven.webpos.infrastructure.model.response.BaseResponse;
import raven.webpos.model.request.CustomerRequest;
import raven.webpos.service.CustomerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<BaseResponse>> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @PostMapping
    public BaseResponse create(@RequestBody CustomerRequest request) {
        return customerService.create(request);
    }

    @PutMapping("{id}")
    public void update(@RequestBody CustomerRequest request, @PathVariable Integer id) {
        customerService.update(request, id);
    }
}
