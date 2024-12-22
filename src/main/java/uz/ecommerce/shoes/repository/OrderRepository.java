package uz.ecommerce.shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ecommerce.shoes.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}