package ru.niack.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.niack.users.api.dto.UserCreateDTO;
import ru.niack.users.entity.User;
import ru.niack.users.repository.IUserRepository;

import java.util.List;

@Service
public class UserService {
  @Autowired
  private IUserRepository userRepository;

  public User findById(Long id){
    return this.userRepository.findById(id).orElseThrow(RuntimeException::new);
  }

  public List<User> findAll(){
    return this.userRepository.findAll();
  }

  public Long add(UserCreateDTO userData) {
    User user = userData.getId() == null ? new User() : findById(userData.getId());

    user.setUsername(userData.getUsername());
    user.setEmail(userData.getEmail());
    user.setPassword(userData.getPassword());
    user.setDeleted(userData.isDeleted());

    return this.userRepository.save(user).getId();
  }

  public Long update(Long id, UserCreateDTO userData){
    userData.setId(id);
    return add(userData);
  }

  public Long delete(Long id, UserCreateDTO userData){
    userData.setId(id);
    userData.setDeleted(true);
    return add(userData);
  }

}
