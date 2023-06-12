package me.aksaev.GeneratorExamQuestions.service.impl;

import me.aksaev.GeneratorExamQuestions.exception.QuestionAlreadyExistsException;
import me.aksaev.GeneratorExamQuestions.exception.QuestionNotFoundException;
import me.aksaev.GeneratorExamQuestions.exception.QuestionsAreEmptyException;
import me.aksaev.GeneratorExamQuestions.model.Question;
import me.aksaev.GeneratorExamQuestions.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer)); // Делегация
    }

    @Override
    public Question add(Question question) {
        if (!questions.add(question)) {
            throw new QuestionAlreadyExistsException();
        }
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.remove(question)) {
            throw new QuestionNotFoundException();
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new QuestionsAreEmptyException();
        }
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
    }

}
