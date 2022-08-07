package ru.niack.quizzes.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.lang.NonNull;
import ru.niack.quizzes.entity.Quiz;
import ru.niack.users.entity.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuizGetDTO {

  @NonNull
  private Long id;
  @NonNull
  private String title;

  private User author;

  private boolean deleted;

  private boolean visible;

  public QuizGetDTO(Quiz quiz){
    this.id = quiz.getId();
    this.title = quiz.getTitle();
    this.deleted = quiz.isDeleted();
    this.visible = quiz.isVisible();
  }

}
