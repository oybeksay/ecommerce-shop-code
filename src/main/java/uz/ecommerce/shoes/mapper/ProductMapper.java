package uz.ecommerce.shoes.mapper;

import org.mapstruct.Mapper;
import uz.ecommerce.shoes.dto.ProductDto;
import uz.ecommerce.shoes.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductDto productDto);

}
