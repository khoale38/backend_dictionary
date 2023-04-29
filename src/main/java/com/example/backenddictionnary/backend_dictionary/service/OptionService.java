package com.example.backenddictionnary.backend_dictionary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.example.backenddictionnary.backend_dictionary.repository.QuestionRepository;
import com.example.backenddictionnary.backend_dictionary.repository.TestRepository;

@Service
public class OptionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    
}
