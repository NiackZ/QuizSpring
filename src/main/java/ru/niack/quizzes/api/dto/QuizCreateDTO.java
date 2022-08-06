package ru.niack.quizzes.api.dto;

import lombok.*;
import org.springframework.lang.NonNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuizCreateDTO {

  private Long id;
  @NonNull
  private String title;
  @NonNull
  private Long author_id;

  private boolean deleted = false;

  private boolean visible = false;

}
