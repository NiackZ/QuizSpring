package ru.niack.users.api.dto;

import lombok.*;
import org.springframework.lang.NonNull;

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

}
