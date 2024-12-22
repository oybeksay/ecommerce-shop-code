package uz.ecommerce.shoes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.ecommerce.shoes.dto.ProductCategoryDto;
import uz.ecommerce.shoes.dto.ProductDto;
import uz.ecommerce.shoes.entity.ProductCategory;
import uz.ecommerce.shoes.exception.ResourceNotFound;
import uz.ecommerce.shoes.repository.ProductCategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory createProductCategory(ProductCategoryDto productCategoryDto) {
        ProductCategory productCategory = ProductCategory.builder()
                .name(productCategoryDto.name())
                .build();
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public ProductCategory findProductCategoryById(Long id) {
        return productCategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Product category not found by id :" + id));
    }

    @Override
    public List<ProductCategory> findAllProductCategories() {
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory updateProductCategory(Long id, ProductCategoryDto productCategoryDto) {
        ProductCategory productCategory = ProductCategory.builder()
                .id(id)
                .name(productCategoryDto.name())
                .build();
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public void deleteProductCategoryById(Long id) {
        productCategoryRepository.deleteById(id);
    }
}
