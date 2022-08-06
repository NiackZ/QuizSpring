package ru.niack.quizzes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.niack.quizzes.api.dto.QuizCreateDTO;
import ru.niack.quizzes.entity.Quiz;
import ru.niack.quizzes.repository.IQuizRepository;
import ru.niack.users.repository.IUserRepository;
import ru.niack.users.service.UserService;

import java.util.List;

@Service
public class QuizService {
  @Autowired
  private IQuizRepository quizRepository;
  private UserService userService;

  public Quiz findById(Long id){
    return this.quizRepository.findById(id).orElseThrow(RuntimeException::new);
  }

  public List<Quiz> findAll(){
    return this.quizRepository.findAll();
  }

  public Long add(QuizCreateDTO quizCreateDTO) {
    Quiz quiz = quizCreateDTO.getId() == null ? new Quiz() : findById(quizCreateDTO.getId());

    quiz.setTitle(quizCreateDTO.getTitle());
    quiz.setAuthor(this.userService.findById(quizCreateDTO.getAuthor_id()));
    quiz.setDeleted(quizCreateDTO.isDeleted());
    quiz.setVisible(quizCreateDTO.isVisible());

    return this.quizRepository.save(quiz).getId();
  }

  public Long update(Long id, QuizCreateDTO quizCreateDTO){
    quizCreateDTO.setId(id);
    return add(quizCreateDTO);
  }

  public Long delete(Long id, QuizCreateDTO quizCreateDTO){
    quizCreateDTO.setId(id);
    quizCreateDTO.setDeleted(true);
    return add(quizCreateDTO);
  }

}
