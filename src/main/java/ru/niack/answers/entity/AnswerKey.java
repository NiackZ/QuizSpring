package ru.niack.answers.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AnswerKey {

  private Long questionId;

  private Long answerId;

}
