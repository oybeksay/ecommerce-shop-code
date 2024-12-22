package uz.ecommerce.shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ecommerce.shoes.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}