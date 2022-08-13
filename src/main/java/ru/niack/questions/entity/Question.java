package ru.niack.questions.entity;

import lombok.*;
import ru.niack.quizzes.entity.Quiz;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "questions")
public class Question {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String text;

  @ManyToOne(fetch = FetchType.LAZY)
  private Quiz quiz;
}
