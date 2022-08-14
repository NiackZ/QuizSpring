package ru.niack.answers.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.niack.answers.entity.Answer;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnswerGetDTO {
  @NotNull
  private Long id;

  @NotNull
  private String text;

  public AnswerGetDTO(Answer answer){
    this.id = answer.getId();
    this.text = answer.getText();
  }

}
