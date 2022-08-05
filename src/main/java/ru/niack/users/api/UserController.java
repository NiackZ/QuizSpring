package ru.niack.users.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import ru.niack.users.api.dto.UserCreateDTO;
import ru.niack.users.entity.User;
import ru.niack.users.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping()
  public List<User> getAll(){
    return userService.findAll();
  }

  @GetMapping("{id}")
  public User getById(@PathVariable Long id){
    return userService.findById(id);
  }

  @PostMapping
  public Long create(UserCreateDTO userDTO){
    return userService.add(userDTO);
  }

  @PutMapping("{id}")
  public Long create(@PathVariable @NonNull Long id, UserCreateDTO userDTO){
    return userService.update(id, userDTO);
  }

  @DeleteMapping("{id}")
  public Long delete(@PathVariable @NonNull Long id, UserCreateDTO userDTO){
    return userService.delete(id, userDTO);
  }

}
