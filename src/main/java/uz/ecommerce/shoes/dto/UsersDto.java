package uz.ecommerce.shoes.dto;

import uz.ecommerce.shoes.entity.Users;

import java.io.Serializable;

/**
 * DTO for {@link Users}
 */
public record UsersDto(String fullName, String email, String phoneNumber, String password) implements Serializable {
}