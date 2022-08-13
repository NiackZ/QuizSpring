package ru.niack.questions.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionCreateDTO {

  private Long id;

  @NotNull
  private String text;
  @NotNull
  private Long quizId;

}
