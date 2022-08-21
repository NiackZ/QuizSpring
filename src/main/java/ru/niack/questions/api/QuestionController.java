package ru.niack.questions.api;

import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;
import ru.niack.answers.entity.Answer;
import ru.niack.answers.service.AnswerService;
import ru.niack.questions.api.dto.QuestionCreateDTO;
import ru.niack.questions.api.dto.QuestionGetDTO;
import ru.niack.questions.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

  @Autowired
  private QuestionService questionService;

  @Autowired
  private AnswerService answerService;

  @GetMapping()
  public List<QuestionGetDTO> getAll() {
    return this.questionService.findAll();
  }

  @GetMapping("{id}")
  public QuestionGetDTO getById(@PathVariable @NotNull Long id) {
    return this.questionService.getById(id);
  }

  @PostMapping
  public Long create(@RequestBody @NotNull QuestionCreateDTO questionCreateDTO) {
    return this.questionService.add(questionCreateDTO);
  }

  @PutMapping("{id}")
  public Long update(@PathVariable @NotNull Long id, @RequestBody @NotNull QuestionCreateDTO questionCreateDTO) {
    return this.questionService.update(id, questionCreateDTO);
  }

  @DeleteMapping("{id}")
  public Long delete(@PathVariable @NotNull Long id) {
    return this.questionService.delete(id);
  }

  @PostMapping("{id}/answerkey")
  public Long setAnswerKey(@PathVariable @NotNull Long id, @NotNull @RequestParam(value = "answerId") Long answerId) {
    return this.questionService.setAnswerKey(id, this.answerService.findById(answerId));
  }

  @DeleteMapping("{id}/answerkey")
  public Long deleteAnswerKey(@PathVariable @NotNull Long id) {
    return this.questionService.deleteAnswerKey(id);
  }
}
