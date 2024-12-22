package uz.ecommerce.shoes.service;

import uz.ecommerce.shoes.dto.ProductCategoryDto;
import uz.ecommerce.shoes.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    ProductCategory createProductCategory(ProductCategoryDto productCategoryDto);

    ProductCategory findProductCategoryById(Long id);

    List<ProductCategory> findAllProductCategories();

    ProductCategory updateProductCategory(Long id, ProductCategoryDto productCategoryDto);

    void deleteProductCategoryById(Long id);

}
