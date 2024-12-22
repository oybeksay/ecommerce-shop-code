package uz.ecommerce.shoes.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link uz.ecommerce.shoes.entity.ProductCategory}
 */
public record ProductCategoryDto(@NotNull String name) implements Serializable {
}