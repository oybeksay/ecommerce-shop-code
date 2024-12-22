package uz.ecommerce.shoes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ecommerce.shoes.dto.ProductCategoryDto;
import uz.ecommerce.shoes.entity.ProductCategory;
import uz.ecommerce.shoes.service.ProductCategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class ProductCategoryController {


    private final ProductCategoryService productCategoryService;

    @PostMapping("/create")
    public ResponseEntity<ProductCategory> createCategory(@RequestBody ProductCategoryDto productCategoryDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productCategoryService.createProductCategory(productCategoryDto));
    }

    @GetMapping
    public ResponseEntity<List<ProductCategory>> findAllCategories() {
        return ResponseEntity.ok(productCategoryService.findAllProductCategories());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductCategory> updateCategory(@PathVariable Long id, @RequestBody ProductCategoryDto productCategoryDto) {
        return ResponseEntity.status(200).body(productCategoryService.updateProductCategory(id, productCategoryDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Long id) {
        productCategoryService.deleteProductCategoryById(id);
        return ResponseEntity.notFound().build();
    }

}
