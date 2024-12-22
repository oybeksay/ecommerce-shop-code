package uz.ecommerce.shoes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.ecommerce.shoes.dto.UsersDto;
import uz.ecommerce.shoes.entity.Users;
import uz.ecommerce.shoes.exception.ResourceNotFound;
import uz.ecommerce.shoes.mapper.UsersMapper;
import uz.ecommerce.shoes.repository.UsersRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersMapper usersMapper;
    private final UsersRepository usersRepository;

    @Override
    public Users createUser(UsersDto usersDto) {
        Users user = usersMapper.toEntity(usersDto);
        return usersRepository.save(user);
    }

    @Override
    public Users findById(Long id) {
        return usersRepository.findById(id).orElseThrow(() -> new ResourceNotFound("User not found by id :" + id));
    }

    @Override
    public List<Users> findAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users updateUser(Long id, UsersDto usersDto) {
        Users user = usersMapper.toEntity(usersDto);
        user.setId(id);
        return usersRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        usersRepository.deleteById(id);
    }
}
