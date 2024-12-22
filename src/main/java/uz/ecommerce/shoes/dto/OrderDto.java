package uz.ecommerce.shoes.dto;

import uz.ecommerce.shoes.domein.OrderStatus;
import uz.ecommerce.shoes.domein.PaymentMethod;
import uz.ecommerce.shoes.entity.Order;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link Order}
 */
public record OrderDto(OrderStatus status, PaymentMethod paymentMethod, LocalDate orderDate, List<Long> requestsIds) implements Serializable {
}