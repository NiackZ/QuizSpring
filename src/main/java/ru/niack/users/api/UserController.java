package ru.niack.users.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import ru.niack.users.api.dto.UserCreateDTO;
import ru.niack.users.api.dto.UserGetDTO;
import ru.niack.users.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping()
  public List<UserGetDTO> getAll(){
    return this.userService.findAll();
  }

  @GetMapping("{id}")
  public UserGetDTO getById(@PathVariable Long id){
    return this.userService.getById(id);
  }

  @PostMapping
  public Long create(@RequestBody UserCreateDTO userDTO){
    return this.userService.add(userDTO);
  }

  @PutMapping("{id}")
  public Long create(@PathVariable @NonNull Long id, @RequestBody UserCreateDTO userDTO){
    return this.userService.update(id, userDTO);
  }

  @DeleteMapping("{id}")
  public Long delete(@PathVariable @NonNull Long id, @RequestBody UserCreateDTO userDTO){
    return this.userService.delete(id, userDTO);
  }

}
