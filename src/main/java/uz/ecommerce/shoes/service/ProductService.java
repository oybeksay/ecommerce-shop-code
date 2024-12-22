package uz.ecommerce.shoes.service;

import org.springframework.web.multipart.MultipartFile;
import uz.ecommerce.shoes.dto.ProductDto;
import uz.ecommerce.shoes.entity.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(ProductDto productDto, List<MultipartFile> files);

    Product findProductById(Long id);

    List<Product> findAllProducts();

    Product updateProduct(Long id, ProductDto productDto);

    void deleteProductById(Long id);

}
