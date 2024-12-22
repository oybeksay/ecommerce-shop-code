package uz.ecommerce.shoes.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ecommerce.shoes.entity.Request;
import uz.ecommerce.shoes.entity.RequestDto;
import uz.ecommerce.shoes.service.RequestService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/basket")
@Tag(name = "Basket Manager")
public class RequestController {

    private final RequestService requestService;

    @PostMapping("/create")
    public ResponseEntity<Request> createRequest(@RequestBody RequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(requestService.createRequest(requestDto));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Request> findRequestById(@PathVariable Long id) {
        return ResponseEntity.ok(requestService.findRequestById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Request>> findAllRequestsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(requestService.findAllRequestsByUserId(userId));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Request>> findAllRequestsByProductId(@PathVariable Long productId) {
        return ResponseEntity.ok(requestService.findAllRequestsByProductId(productId));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRequestById(@PathVariable Long id) {
        requestService.deleteRequestById(id);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/delete/user/{userId}")
    public ResponseEntity<Void> deleteRequestByUserId(@PathVariable Long userId) {
        requestService.deleteRequestByUserId(userId);
        return ResponseEntity.noContent().build();
    }
}
