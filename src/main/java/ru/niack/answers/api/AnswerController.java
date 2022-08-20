package ru.niack.answers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.niack.answers.api.dto.AnswerCreateDTO;
import ru.niack.answers.api.dto.AnswerGetDTO;
import ru.niack.answers.entity.AnswerKey;
import ru.niack.answers.service.AnswerService;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {

  @Autowired
  private AnswerService answerService;

  @GetMapping
  public List<AnswerGetDTO> getAll(){
    return this.answerService.findAll();
  }

  @GetMapping("{id}")
  public AnswerGetDTO getById(@PathVariable Long id){
    return this.answerService.getById(id);
  }

  @PostMapping
  public Long create(@NotNull @RequestBody AnswerCreateDTO answerCreateDTO){
    return this.answerService.add(answerCreateDTO);
  }

  @PutMapping("{id}")
  public Long update(@NotNull @PathVariable Long id, @NotNull @RequestBody AnswerCreateDTO answerCreateDTO){
    answerCreateDTO.setId(id);
    return this.answerService.update(answerCreateDTO);
  }

  @DeleteMapping("{id}")
  public Long delete(@NotNull @PathVariable Long id){
    return this.answerService.delete(id);
  }

  @PostMapping("{id}/answerkey")
  public Long setAsAnswerKey(@NotNull @PathVariable Long id, @NotNull @RequestParam(value = "questionId") Long questionId){
    return this.answerService.setAsAnswerKey(new AnswerKey()
        .builder()
        .answerId(id)
        .questionId(questionId)
        .build()
    );
  }

}
