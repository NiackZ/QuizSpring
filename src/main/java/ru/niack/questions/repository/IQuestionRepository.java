package ru.niack.questions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.niack.questions.entity.Question;

public interface IQuestionRepository extends JpaRepository<Question, Long> {
}
