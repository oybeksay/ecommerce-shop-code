package uz.ecommerce.shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ecommerce.shoes.entity.Feedback;

import java.util.List;

public interface FeedBackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findAllByProduct_Id(Long productId);
}