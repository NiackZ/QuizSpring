package ru.niack.users.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.niack.users.api.dto.UserCreateDTO;
import ru.niack.users.api.dto.UserGetDTO;
import ru.niack.users.service.UserService;

import javax.validation.constraints.NotNull;
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
  public UserGetDTO getById(@PathVariable @NotNull Long id){
    return this.userService.getById(id);
  }

  @PostMapping
  public Long create(@RequestBody @NotNull UserCreateDTO userDTO){
    return this.userService.add(userDTO);
  }

  @PutMapping("{id}")
  public Long update(@PathVariable @NotNull Long id, @RequestBody @NotNull UserCreateDTO userDTO){
    userDTO.setId(id);
    return this.userService.update(userDTO);
  }

  @DeleteMapping("{id}")
  public Long delete(@PathVariable @NotNull Long id, @RequestBody @NotNull UserCreateDTO userDTO){
    userDTO.setId(id);
    return this.userService.delete(userDTO);
  }

}
