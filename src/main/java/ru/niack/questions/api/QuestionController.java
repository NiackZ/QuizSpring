package ru.niack.questions.api;

import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;
import ru.niack.questions.api.dto.QuestionCreateDTO;
import ru.niack.questions.api.dto.QuestionGetDTO;
import ru.niack.questions.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

  @Autowired
  private QuestionService questionService;

  @GetMapping()
  public List<QuestionGetDTO> getAll() {
    return this.questionService.findAll();
  }

  @GetMapping("{id}")
  public QuestionGetDTO getById(@PathVariable Long id) {
    return this.questionService.getById(id);
  }

  @PostMapping
  public Long create(@RequestBody QuestionCreateDTO questionCreateDTO) {
    return this.questionService.add(questionCreateDTO);
  }

  @PutMapping("{id}")
  public Long update(@PathVariable @NotNull Long id, @RequestBody QuestionCreateDTO questionCreateDTO) {
    return this.questionService.update(id, questionCreateDTO);
  }

  @DeleteMapping("{id}")
  public Long delete(@PathVariable @NotNull Long id) {
    return this.questionService.delete(id);
  }
}
