package uz.ecommerce.shoes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.ecommerce.shoes.dto.ProductDto;
import uz.ecommerce.shoes.entity.Product;
import uz.ecommerce.shoes.entity.ProductCategory;
import uz.ecommerce.shoes.exception.ResourceNotFound;
import uz.ecommerce.shoes.mapper.ProductMapper;
import uz.ecommerce.shoes.repository.ProductRepository;
import uz.ecommerce.shoes.util.FileService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final FileService fileService;
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final ProductCategoryService productCategoryService;

    @Override
    public Product createProduct(ProductDto productDto, List<MultipartFile> files) {
        Product product = productMapper.toEntity(productDto);
        ProductCategory productCategory = productCategoryService.findProductCategoryById(productDto.categoryId());
        List<String> uploadFiles = fileService.uploadFiles(files);
        product.setThumbnails(uploadFiles);
        product.setCategory(productCategory);
        return productRepository.save(product);
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Product not found by id :" + id));
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Long id, ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        Product product = findProductById(id);
        fileService.deleteFiles(product.getThumbnails());
        productRepository.deleteById(id);
    }

}
