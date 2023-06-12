package me.aksaev.GeneratorExamQuestions.service;

import me.aksaev.GeneratorExamQuestions.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestion(int amount);
}
