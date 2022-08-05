package ru.niack.users.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
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
  public Long create(User userData){
    return userService.add(userData);
  }

  @PutMapping("{id}")
  public Long create(@PathVariable @NonNull Long id, User userData){
    return userService.update(id, userData);
  }

  @DeleteMapping("{id}")
  public Long delete(@PathVariable @NonNull Long id, User userData){
    return userService.delete(id, userData);
  }

}
