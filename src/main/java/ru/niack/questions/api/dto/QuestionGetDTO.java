package ru.niack.questions.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import ru.niack.questions.entity.Question;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionGetDTO {

  @NotNull
  private Long id;
  @NotNull
  private String text;

  public QuestionGetDTO(Question questionData){
    this.id = questionData.getId();
    this.text = questionData.getText();
  }

}
