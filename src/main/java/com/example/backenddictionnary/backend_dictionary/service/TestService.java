package com.example.backenddictionnary.backend_dictionary.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.example.backenddictionnary.backend_dictionary.models.Question;
import com.example.backenddictionnary.backend_dictionary.models.Test;
import com.example.backenddictionnary.backend_dictionary.repository.TestRepository;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private QuestionService questionService;

    public List<Test> getAllTest() {
        return testRepository.findAll();
    }

    public Test addTest(Test test) {
        return testRepository.save(test);
    }

    public void deleteTest(String id) {
         testRepository.deleteById(id);
    }


    public Test editTest(Test test,String testId) {
        Test existingTest= testRepository.findById(testId).orElse(null);

        if (existingTest!= null) {
            existingTest
                    .setName(test.getName() != null ? test.getName() : existingTest.getName());

            existingTest
                    .setImage(test.getImage() != null ? test.getImage() : existingTest.getImage());
            return testRepository.save(existingTest);
        }
        return null;
    }

    public Test addQuestion(Question question, String id) {
        Test findTest = testRepository.findById(id).orElse(null);
        List<Question> oldQuestion = findTest.getQuestions();

        if (oldQuestion != null) {
            oldQuestion.add(questionService.addQuestion(question));
            findTest.setQuestions(oldQuestion);
        } else
            findTest.setQuestions((Arrays.asList(questionService.addQuestion(question))));

        return testRepository.save(findTest);

    }

    
}
