package uz.ecommerce.shoes.mapper;

import org.mapstruct.Mapper;
import uz.ecommerce.shoes.dto.UsersDto;
import uz.ecommerce.shoes.entity.Users;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    Users toEntity(UsersDto usersDto);

}
