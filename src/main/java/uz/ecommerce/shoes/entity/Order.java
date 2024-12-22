package uz.ecommerce.shoes.entity;

import jakarta.persistence.*;
import lombok.*;
import org.w3c.dom.stylesheets.LinkStyle;
import uz.ecommerce.shoes.domein.OrderStatus;
import uz.ecommerce.shoes.domein.PaymentMethod;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"requests"})
@Getter
@Setter
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private LocalDate orderDate;

    private Double totalPrice;

    @OneToMany
    @JoinColumn(name = "request_id")
    private List<Request> requests;
}
