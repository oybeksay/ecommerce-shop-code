package uz.ecommerce.shoes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ecommerce.shoes.dto.UsersDto;
import uz.ecommerce.shoes.entity.Users;
import uz.ecommerce.shoes.service.UsersService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UsersController {

    private final UsersService usersService;

    @PostMapping("/create")
    public ResponseEntity<Users> createUser(@RequestBody UsersDto usersDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(usersService.createUser(usersDto));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Users> findById(@PathVariable Long id){
        return ResponseEntity.ok(usersService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Users>> findAllUsers(){
        return ResponseEntity.ok(usersService.findAllUsers());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody UsersDto usersDto){
        return ResponseEntity.status(200).body(usersService.updateUser(id,usersDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
        usersService.deleteUserById(id);
        return ResponseEntity.notFound().build();
    }
}
