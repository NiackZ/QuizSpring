package ru.niack.questions.service;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.niack.answers.entity.Answer;
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

  private QuestionGetDTO setAsQGDTO(Question question){
    QuestionGetDTO questionGetDTO = new QuestionGetDTO(question);
    questionGetDTO.setAnswers(question.getAnswers());
    return questionGetDTO;
  }

  public Question findById(@NotNull Long id){
    return this.questionRepository.findById(id).orElseThrow(
        () -> new RuntimeException(String.format("Вопрос с ИД %d не найден", id))
    );
  }

  public QuestionGetDTO getById(@NotNull Long id){
    return setAsQGDTO(findById(id));
  }

  public List<QuestionGetDTO> findAll(){
    return this.questionRepository.findAll().stream().map(this::setAsQGDTO).toList();
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

  public Long setAnswerKey(@NotNull Long questionId, Answer answer){
    Question question = findById(questionId);
    boolean loopAnswer = question.getAnswers().stream().map(Answer::getId).anyMatch(answer.getId()::equals);
    if (loopAnswer)
      throw new RuntimeException(String.format(
          "Ошибка рекурсии. Нельзя назначить ответ с ИД=%d, так как он привязан к привязываемому вопросу.", answer.getId()));
    question.setAnswerKey(answer);
    return this.questionRepository.save(question).getId();
  }

}
