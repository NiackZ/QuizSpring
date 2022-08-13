package ru.niack.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.niack.users.api.dto.UserCreateDTO;
import ru.niack.users.api.dto.UserGetDTO;
import ru.niack.users.entity.User;
import ru.niack.users.repository.IUserRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@Service
public class UserService {
  @Autowired
  private IUserRepository userRepository;

  public User findById(@NotNull Long id){
    return this.userRepository.findById(id).orElseThrow(
        () -> new RuntimeException(String.format("Пользователь с ИД %d не найден", id))
    );
  }

  public UserGetDTO getById(@NotNull Long id){
    return new UserGetDTO(this.userRepository.findById(id).orElseThrow(
        () -> new RuntimeException(String.format("Пользователь с ИД %d не найден", id))
    ));
  }

  public List<UserGetDTO> findAll(){
    return this.userRepository.findAll().stream().map(UserGetDTO::new).toList();
  }

  public Long add(@Valid @NotNull UserCreateDTO userData) {
    User user = userData.getId() == null ? new User() : findById(userData.getId());

    user.setUsername(userData.getUsername());
    user.setEmail(userData.getEmail());
    user.setPassword(userData.getPassword());
    user.setDeleted(userData.isDeleted());

    return this.userRepository.save(user).getId();
  }

  public Long update(@NotNull Long id, @Valid @NotNull UserCreateDTO userData){
    userData.setId(id);
    return add(userData);
  }

  public Long delete(@NotNull Long id, @Valid @NotNull UserCreateDTO userData){
    userData.setId(id);
    userData.setDeleted(true);
    return add(userData);
  }

}
