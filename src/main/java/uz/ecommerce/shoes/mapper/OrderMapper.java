package uz.ecommerce.shoes.mapper;

import org.mapstruct.Mapper;
import uz.ecommerce.shoes.entity.Order;
import uz.ecommerce.shoes.dto.OrderDto;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toEntity(OrderDto orderDto);

}
