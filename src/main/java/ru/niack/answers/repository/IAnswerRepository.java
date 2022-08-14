package ru.niack.answers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.niack.answers.entity.Answer;

public interface IAnswerRepository extends JpaRepository<Answer, Long> {
}
