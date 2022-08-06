package ru.niack.quizzes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.niack.quizzes.entity.Quiz;

public interface IQuizRepository extends JpaRepository<Quiz, Long> {

}
