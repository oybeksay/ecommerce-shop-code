package uz.ecommerce.shoes.dto;

import jakarta.validation.constraints.NotNull;
import uz.ecommerce.shoes.entity.Product;

import java.io.Serializable;

/**
 * DTO for {@link Product}
 */
public record ProductDto(@NotNull String name, @NotNull String description, @NotNull Long categoryId,
                         @NotNull String brandName, @NotNull String sku, @NotNull Integer stockQuantity,
                         @NotNull Double regularPrice, @NotNull Double salePrice) implements Serializable {
}