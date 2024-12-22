package uz.ecommerce.shoes.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.ecommerce.shoes.dto.AppErrorDto;
import uz.ecommerce.shoes.exception.ResourceNotFound;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<AppErrorDto> handlerResourceNotFoundException(ResourceNotFound ex, HttpServletRequest request){
        AppErrorDto appErrorDto = AppErrorDto.builder()
                .errorMessage(ex.getMessage())
                .errorPath(request.getRequestURI())
                .errorCode(404)
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(appErrorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<AppErrorDto> handlerRuntimeException(RuntimeException ex, HttpServletRequest request){
        AppErrorDto appErrorDto = AppErrorDto.builder()
                .errorMessage(ex.getMessage())
                .errorPath(request.getRequestURI())
                .errorCode(500)
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(appErrorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
