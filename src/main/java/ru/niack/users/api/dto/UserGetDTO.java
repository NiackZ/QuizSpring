package ru.niack.users.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import ru.niack.quizzes.api.dto.QuizGetDTO;
import ru.niack.quizzes.entity.Quiz;
import ru.niack.users.entity.User;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserGetDTO {

  @NotNull
  private Long id;
  @NotNull
  private String username;
  @NotNull
  private String email;

  private List<QuizGetDTO> quizzes = new ArrayList<>();

  private boolean deleted;

  public UserGetDTO(User user){
    this.id = user.getId();
    this.username = user.getUsername();
    this.email = user.getEmail();
    this.deleted = user.isDeleted();
    this.quizzes = null;
  }

  public void setQuizzes(List<Quiz> quizzes) {
    this.quizzes = quizzes.stream().map(quiz -> {
      QuizGetDTO quizGetDTO = new QuizGetDTO(quiz);
      quizGetDTO.setQuestions(quiz.getQuestions());
      return quizGetDTO;
    }).toList();
  }
}
