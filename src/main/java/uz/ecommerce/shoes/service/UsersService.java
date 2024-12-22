package uz.ecommerce.shoes.service;


import uz.ecommerce.shoes.dto.UsersDto;
import uz.ecommerce.shoes.entity.Users;

import java.util.List;

public interface UsersService {

    Users createUser(UsersDto usersDto);

    Users findById(Long id);

    List<Users> findAllUsers();

    Users updateUser(Long id, UsersDto usersDto);

    void deleteUserById(Long id);

}
