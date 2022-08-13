package ru.niack.questions.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.lang.NonNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionCreateDTO {

  private Long id;

  @NonNull
  private String text;
  @NonNull
  private Long quizId;

}
