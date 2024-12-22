package uz.ecommerce.shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ecommerce.shoes.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
}