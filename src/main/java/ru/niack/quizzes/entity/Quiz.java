package ru.niack.quizzes.entity;

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

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
  @JoinColumn(name = "author_id")
  private User author;

  @ColumnDefault("false")
  private boolean visible;

  @ColumnDefault("false")
  private boolean deleted;

}
