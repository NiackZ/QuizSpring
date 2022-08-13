package ru.niack.questions.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import ru.niack.questions.entity.Question;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionGetDTO {

  private Long id;

  private String text;

  public QuestionGetDTO(Question questionData){
    this.id = questionData.getId();
    this.text = questionData.getText();
  }

}
