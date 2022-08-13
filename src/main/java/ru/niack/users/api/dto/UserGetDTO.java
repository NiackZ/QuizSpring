package ru.niack.users.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import ru.niack.quizzes.api.dto.QuizGetWOAuthorDTO;
import ru.niack.users.entity.User;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserGetDTO {

  private Long id;

  private String username;

  private String email;

  private List<QuizGetWOAuthorDTO> quizzes = new ArrayList<>();

  private boolean deleted;

  public UserGetDTO(User user){
    this.id = user.getId();
    this.username = user.getUsername();
    this.email = user.getEmail();
    this.deleted = user.isDeleted();
    this.quizzes = user.getQuizzes().stream().map(QuizGetWOAuthorDTO::new).toList();
  }
}
