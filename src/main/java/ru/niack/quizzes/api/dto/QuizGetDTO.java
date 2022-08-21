package ru.niack.quizzes.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import javax.validation.constraints.NotNull;
import ru.niack.questions.api.dto.QuestionGetDTO;
import ru.niack.questions.entity.Question;
import ru.niack.quizzes.entity.Quiz;
import ru.niack.users.api.dto.UserCreateDTO;
import ru.niack.users.entity.User;

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
    this.author = null;
    this.questions = null;
  }

  public void setAuthor(User user) {
    this.author = new UserCreateDTO(user);
  }

  public void setQuestions(List<Question> questions) {
    this.questions = questions.stream().map(QuestionGetDTO::new).toList();
  }

  public void setQuestionsFromDTO(List<QuestionGetDTO> questions) {
    this.questions = questions;
  }

}
