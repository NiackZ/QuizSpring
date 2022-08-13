package ru.niack.quizzes.api.dto;

import lombok.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuizCreateDTO {

  private Long id;
  @NotNull
  private String title;
  @NotNull
  private Long authorId;

  private boolean deleted = false;

  private boolean visible = false;

}
