package com.example.backenddictionnary.backend_dictionary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.backenddictionnary.backend_dictionary.models.UnitHasVocabulary;
import com.example.backenddictionnary.backend_dictionary.repository.UnitHasVocabularyRepository;

@Service
public class UnitHasVocabularyService {
    @Autowired
    private UnitHasVocabularyRepository unitHasVocabularyRepository;
    @Autowired
    private MongoTemplate mongoTemplate;


    public List<UnitHasVocabulary> getAllUnitHasVocabulary() {
        return unitHasVocabularyRepository.findAll();
    }

    public UnitHasVocabulary addVocabularyToUnit(UnitHasVocabulary product) {
        return unitHasVocabularyRepository.save(product);
    }

    public UnitHasVocabulary getUnitHasVocabularyById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("unitId").is(id));
        List<UnitHasVocabulary> result = mongoTemplate.find(query, UnitHasVocabulary.class);
        return result.get(0);
    }
}
