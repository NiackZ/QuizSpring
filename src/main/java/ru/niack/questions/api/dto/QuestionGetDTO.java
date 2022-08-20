package ru.niack.questions.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import ru.niack.answers.api.dto.AnswerGetDTO;
import ru.niack.answers.entity.Answer;
import ru.niack.questions.entity.Question;

import javax.validation.constraints.NotNull;
import java.util.List;

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
  @NotNull
  private List<AnswerGetDTO> answers;

  private AnswerGetDTO answerKey = null;

  public QuestionGetDTO(Question questionData){
    this.id = questionData.getId();
    this.text = questionData.getText();
    if (questionData.getAnswerKey() != null)
      this.answerKey = new AnswerGetDTO(questionData.getAnswerKey());
  }

  public void setAnswers(List<Answer> answers) {
    this.answers = answers.stream().map(AnswerGetDTO::new).toList();
  }
}
