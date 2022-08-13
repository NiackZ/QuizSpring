package ru.niack.questions.service;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.niack.questions.api.dto.QuestionCreateDTO;
import ru.niack.questions.api.dto.QuestionGetDTO;
import ru.niack.questions.entity.Question;
import ru.niack.questions.repository.IQuestionRepository;
import ru.niack.quizzes.service.QuizService;

import java.util.List;

@Validated
@Service
public class QuestionService {
  @Autowired
  private IQuestionRepository questionRepository;
  @Autowired
  private QuizService quizService;

  public Question findById(@NotNull Long id){
    return this.questionRepository.findById(id).orElseThrow(
        () -> new RuntimeException(String.format("Вопрос с ИД %d не найден", id))
    );
  }

  public QuestionGetDTO getById(@NotNull Long id){
    return new QuestionGetDTO(this.questionRepository.findById(id).orElseThrow(
        () -> new RuntimeException(String.format("Вопрос с ИД %d не найден", id))
    ));
  }

  public List<QuestionGetDTO> findAll(){
    return this.questionRepository.findAll().stream().map(QuestionGetDTO::new).toList();
  }

  public Long add(@NotNull @Valid QuestionCreateDTO questionCreateDTO) {
    Question question = questionCreateDTO.getId() == null ? new Question() : findById(questionCreateDTO.getId());

    question.setText(questionCreateDTO.getText());
    question.setQuiz(this.quizService.findById(questionCreateDTO.getQuizId()));

    return this.questionRepository.save(question).getId();
  }

  public Long update(@NotNull Long id, @NotNull @Valid QuestionCreateDTO questionCreateDTO){
    questionCreateDTO.setId(id);
    return add(questionCreateDTO);
  }

  public Long delete(@NotNull Long id){
    this.questionRepository.deleteById(id);
    return id;
  }

}
