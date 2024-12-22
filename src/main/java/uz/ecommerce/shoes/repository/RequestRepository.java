package uz.ecommerce.shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ecommerce.shoes.entity.Request;
import uz.ecommerce.shoes.entity.Users;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findAllByUser_Id(Long userId);

    Long user(Users user);

    List<Request> findAllByProduct_Id(Long productId);

    void deleteAllByUser_Id(Long userId);
}