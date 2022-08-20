package ru.niack.questions.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import ru.niack.answers.entity.Answer;
import ru.niack.quizzes.entity.Quiz;

import javax.persistence.*;
import java.util.List;

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

  @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
  private List<Answer> answers;

  @OneToOne
  @ColumnDefault("null")
  private Answer answerKey;
}
