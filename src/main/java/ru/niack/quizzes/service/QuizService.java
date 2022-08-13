package ru.niack.quizzes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.niack.quizzes.api.dto.QuizCreateDTO;
import ru.niack.quizzes.api.dto.QuizGetDTO;
import ru.niack.quizzes.entity.Quiz;
import ru.niack.quizzes.repository.IQuizRepository;
import ru.niack.users.service.UserService;

import java.util.List;

@Service
public class QuizService {
  @Autowired
  private IQuizRepository quizRepository;
  @Autowired
  private UserService userService;

  private Quiz findById(Long id){
    return this.quizRepository.findById(id).orElseThrow(RuntimeException::new);
  }

  public QuizGetDTO getById(Long id){
    //todo убрать пароль
    return new QuizGetDTO(this.quizRepository.findById(id).orElseThrow(
        () -> new RuntimeException(String.format("Опрос с ИД %d не найден", id))
    ));
  }

  public List<QuizGetDTO> findAll(){
    //todo убрать пароль
    return this.quizRepository.findAll().stream().map(QuizGetDTO::new).toList();
  }

  public Long add(QuizCreateDTO quizCreateDTO) {
    Quiz quiz = quizCreateDTO.getId() == null ? new Quiz() : findById(quizCreateDTO.getId());

    quiz.setTitle(quizCreateDTO.getTitle());
    quiz.setAuthor(this.userService.findById(quizCreateDTO.getAuthorId()));
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