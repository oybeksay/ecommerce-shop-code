package uz.ecommerce.shoes.entity;

import jakarta.validation.constraints.NotNull;
import uz.ecommerce.shoes.dto.ProductDto;
import uz.ecommerce.shoes.dto.UsersDto;

import java.io.Serializable;

/**
 * DTO for {@link Request}
 */
public record RequestDto(@NotNull Integer productCount, Long productId, Long userId) implements Serializable {
}