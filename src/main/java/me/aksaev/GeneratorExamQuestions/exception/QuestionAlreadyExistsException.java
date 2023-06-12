package me.aksaev.GeneratorExamQuestions.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT) // Пользотватель хочет добавить то, что уже есть
public class QuestionAlreadyExistsException extends RuntimeException {


}
