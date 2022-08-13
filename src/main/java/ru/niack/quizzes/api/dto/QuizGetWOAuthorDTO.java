package ru.niack.quizzes.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.lang.NonNull;
import ru.niack.questions.api.dto.QuestionGetDTO;
import ru.niack.quizzes.entity.Quiz;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuizGetWOAuthorDTO {

  @NonNull
  private Long id;
  @NonNull
  private String title;

  private List<QuestionGetDTO> questions;

  private boolean deleted;

  private boolean visible;

  public QuizGetWOAuthorDTO(Quiz quiz){
    this.id = quiz.getId();
    this.title = quiz.getTitle();
    this.deleted = quiz.isDeleted();
    this.visible = quiz.isVisible();
    this.questions = quiz.getQuestions().stream().map(QuestionGetDTO::new).toList();
  }

}
