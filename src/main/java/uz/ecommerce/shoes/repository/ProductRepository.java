package uz.ecommerce.shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ecommerce.shoes.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}