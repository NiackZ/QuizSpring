package ru.niack.quizzes.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import ru.niack.users.entity.User;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "quizzes")
public class Quiz {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = false)
  private String title;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "author_id", nullable = false)
  @JsonBackReference
  private User author;

  @ColumnDefault("false")
  private boolean visible;

  @ColumnDefault("false")
  private boolean deleted;

}
