package ru.niack.answers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.niack.answers.api.dto.AnswerCreateDTO;
import ru.niack.answers.api.dto.AnswerGetDTO;
import ru.niack.answers.entity.Answer;
import ru.niack.answers.repository.IAnswerRepository;
import ru.niack.questions.service.QuestionService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@Validated
public class AnswerService {

  @Autowired
  private IAnswerRepository answerRepository;
  @Autowired
  private QuestionService questionService;


  public Answer findById(@NotNull Long id){
    return this.answerRepository.findById(id).orElseThrow(()->
        new RuntimeException(String.format("Ответ с ИД %d не найден.", id))
    );
  }

  public AnswerGetDTO getById(@NotNull Long id){
    return new AnswerGetDTO(findById(id));
  }

  public List<AnswerGetDTO> findAll(){
    return this.answerRepository.findAll().stream().map(AnswerGetDTO::new).toList();
  }

  public Long add(@NotNull @Valid AnswerCreateDTO answerCreateDTO){
    Answer answer = answerCreateDTO.getId() == null ? new Answer() : findById(answerCreateDTO.getId());
    answer.setText(answerCreateDTO.getText());
    answer.setQuestion(this.questionService.findById(answerCreateDTO.getQuestionId()));
    return this.answerRepository.save(answer).getId();
  }

  public Long update(@NotNull @Valid AnswerCreateDTO answerCreateDTO){
    return add(answerCreateDTO);
  }

  public Long delete(@NotNull Long id){
    this.answerRepository.deleteById(id);
    return id;
  }

}
