package uz.ecommerce.shoes.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import uz.ecommerce.shoes.entity.Feedback;

import java.io.Serializable;

/**
 * DTO for {@link Feedback}
 */
public record FeedbackDto(@NotNull String comment, @Min(1) @Max(5) Integer starsCount, Long productId, Long userId) implements Serializable {
}