package ru.niack.users.api.dto;

import lombok.*;
import org.springframework.lang.NonNull;
import ru.niack.users.entity.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateDTO {

  private Long id;
  @NonNull
  private String username;
  @NonNull
  private String email;
  @NonNull
  private String password;

  private boolean deleted = false;

  public UserCreateDTO(User author) {
    this.id = author.getId();
    this.username = author.getUsername();
    this.email = author.getEmail();
    this.password = author.getPassword();
    this.deleted = author.isDeleted();
  }

}
