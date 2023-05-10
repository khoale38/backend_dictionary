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
 

    public List<Test> getAllTest() {
        return testRepository.findAll();
    }

    public Test getTestById( String id) {
        return testRepository.findById(id).orElse(null);
    }
    public Test addTest(Test test) {
        return testRepository.save(test);
    }

    public void deleteTest(String id) {
        testRepository.deleteById(id);
    }

    public Test editTest(Test test, String testId) {
        Test existingTest = testRepository.findById(testId).orElse(null);

        if (existingTest != null) {
            existingTest
                    .setName(test.getName() != null ? test.getName() : existingTest.getName());

            existingTest
                    .setImage(test.getImage() != null ? test.getImage() : existingTest.getImage());
            return testRepository.save(existingTest);
        }
        return null;
    }

    public Test addQuestionToTest(String testid, String questionid) {
        Test findTest = testRepository.findById(testid).orElse(null);
        List<String> oldQuestion = findTest.getQuestions();
        if (oldQuestion == null) {
            findTest.setQuestions(Arrays.asList(questionid));
            return testRepository.save(findTest);
        }
        if(oldQuestion.contains(questionid))
        return testRepository.save(findTest); 

        oldQuestion.add(questionid);
        findTest.setQuestions(oldQuestion);

        return testRepository.save(findTest);

    }

    public Test removeQuestionfromTest(String testid, String questionid) {
        Test findTest = testRepository.findById(testid).orElse(null);
        List<String> oldQuestion = findTest.getQuestions();
        oldQuestion.remove(questionid);
        findTest.setQuestions(oldQuestion);
        return testRepository.save(findTest);

    }

}
