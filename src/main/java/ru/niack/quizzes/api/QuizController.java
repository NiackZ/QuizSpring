package ru.niack.quizzes.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.niack.quizzes.api.dto.QuizCreateDTO;
import ru.niack.quizzes.api.dto.QuizGetDTO;
import ru.niack.quizzes.service.QuizService;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/quizzes")
public class QuizController {

  @Autowired
  private QuizService quizService;

  @GetMapping()
  public List<QuizGetDTO> getAll(){
    return this.quizService.findAll();
  }

  @GetMapping("{id}")
  public QuizGetDTO getById(@PathVariable Long id){
    return this.quizService.getById(id);
  }

  @PostMapping
  public Long create(@RequestBody QuizCreateDTO quizCreateDTO){
    return this.quizService.add(quizCreateDTO);
  }

  @PutMapping("{id}")
  public Long create(@PathVariable @NotNull Long id, @RequestBody QuizCreateDTO quizCreateDTO){
    return this.quizService.update(id, quizCreateDTO);
  }

  @DeleteMapping("{id}")
  public Long delete(@PathVariable @NotNull Long id, @RequestBody QuizCreateDTO quizCreateDTO){
    return this.quizService.delete(id, quizCreateDTO);
  }

}
