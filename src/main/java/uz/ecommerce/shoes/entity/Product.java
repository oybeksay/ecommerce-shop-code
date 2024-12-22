package uz.ecommerce.shoes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"feedbacks", "requests"})
@Getter
@Setter
@Builder
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    private String brandName;

    private String sku;

    @Min(1)
    private Integer stockQuantity;

    private Double regularPrice;

    private Double salePrice;

    @ElementCollection
    private List<String> thumbnails;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Request> requests;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Feedback> feedbacks;
}
