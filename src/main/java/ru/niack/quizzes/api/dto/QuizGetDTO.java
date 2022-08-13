package ru.niack.quizzes.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import javax.validation.constraints.NotNull;
import ru.niack.questions.api.dto.QuestionGetDTO;
import ru.niack.quizzes.entity.Quiz;
import ru.niack.users.api.dto.UserCreateDTO;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuizGetDTO {

  @NotNull
  private Long id;
  @NotNull
  private String title;

  private UserCreateDTO author;

  private List<QuestionGetDTO> questions;

  private boolean deleted;

  private boolean visible;

  public QuizGetDTO(Quiz quiz){
    this.id = quiz.getId();
    this.title = quiz.getTitle();
    this.deleted = quiz.isDeleted();
    this.visible = quiz.isVisible();
    this.author = new UserCreateDTO(quiz.getAuthor());
    this.questions = quiz.getQuestions().stream().map(QuestionGetDTO::new).toList();
  }

}
