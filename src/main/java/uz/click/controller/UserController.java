package uz.click.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.click.dto.UserDto;
import uz.click.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/show")
    public ResponseEntity<List<UserDto>> getAll(){
        return service.getAll();
    }
    @PostMapping("/add")
    public ResponseEntity<UserDto> add(@RequestBody UserDto dto){
    return service.addUser(dto);
    }

    @DeleteMapping("/delte/{id}")
    public ResponseEntity<UserDto> delete(@PathVariable Long id){
    return service.deleteById(id);
    }
}
