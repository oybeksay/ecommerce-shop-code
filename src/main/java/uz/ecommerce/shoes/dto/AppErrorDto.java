package uz.ecommerce.shoes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AppErrorDto {
    private String errorMessage;
    private String errorPath;
    private int errorCode;
    private LocalDateTime timestamp;
}
