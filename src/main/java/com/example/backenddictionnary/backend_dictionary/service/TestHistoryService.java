package com.example.backenddictionnary.backend_dictionary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.backenddictionnary.backend_dictionary.models.TestHistory;
import com.example.backenddictionnary.backend_dictionary.repository.TestHistoryRepository;

@Service
public class TestHistoryService {
    @Autowired
    private TestHistoryRepository testHistoryRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<TestHistory> getAllTestHistory() {
        return testHistoryRepository.findAll();
    }

    public TestHistory addTestHistory(TestHistory test) {
        return testHistoryRepository.save(test);
    }


    public List<TestHistory> getTestHistoryByUser(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        List<TestHistory> result = mongoTemplate.find(query, TestHistory.class);
        return result;
    }


    public void deleteTest(String id) {
        testHistoryRepository.deleteById(id);
    }

}
