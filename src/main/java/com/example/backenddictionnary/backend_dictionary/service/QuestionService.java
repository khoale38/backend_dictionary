package com.example.backenddictionnary.backend_dictionary.service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.example.backenddictionnary.backend_dictionary.models.Question;
import com.example.backenddictionnary.backend_dictionary.repository.QuestionRepository;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(String Id) {
        return questionRepository.findById(Id).orElse(null);
    }

    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question editQuestion(Question question, String id) {
        Question findQuestion = questionRepository.findById(id).orElse(null);

        if (findQuestion != null) {
            findQuestion
                    .setTitle(question.getTitle() != null ? question.getTitle() : findQuestion.getTitle());

            findQuestion
                    .setAnswer(question.getAnswer() != null ? question.getAnswer() : findQuestion.getAnswer());
            findQuestion
                    .setDescription(question.getDescription() != null ? question.getDescription()
                            : findQuestion.getDescription());
            findQuestion
                    .setPoint(question.getPoint() != 0 ? question.getPoint() : findQuestion.getPoint());

            return questionRepository.save(findQuestion);
        }
        return null;

    }

    public void deleteQuestion(String id) {
        questionRepository.deleteById(id);
    }

    public Question addOptionToQuestion(String questionId, String optionId) {
        Question findQuestion = questionRepository.findById(questionId).orElse(null);
        List<String> oldOption = findQuestion.getOptions();
        if (oldOption == null) {
            findQuestion.setOptions((Arrays.asList(optionId)));
            return questionRepository.save(findQuestion);
        }
        if (oldOption.contains(optionId))
            return questionRepository.save(findQuestion);

        oldOption.add(optionId);
        findQuestion.setOptions(oldOption);

        return questionRepository.save(findQuestion);
    }

    public Question removeOptionfromQuestion(String questionId, String optionId) {
        Question findQuestion = questionRepository.findById(questionId).orElse(null);
        List<String> oldOption = findQuestion.getOptions();
        oldOption.remove(optionId);
        findQuestion.setOptions(oldOption);
        return questionRepository.save(findQuestion);

    }
}
