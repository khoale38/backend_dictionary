package com.example.backenddictionnary.backend_dictionary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.backenddictionnary.backend_dictionary.models.FavoriteVocabularies;
import com.example.backenddictionnary.backend_dictionary.repository.FavoriteVocabularyRepository;

@Service
public class FavoriteVocabularyService {
    @Autowired
    private FavoriteVocabularyRepository favoriteVocabularyRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public List<FavoriteVocabularies> getAllFavoriteVocabularies() {
        return favoriteVocabularyRepository.findAll();
    }

    public FavoriteVocabularies getFavoriteVocabulariesById(String vocaId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("vocabularyId").is(vocaId));
       FavoriteVocabularies result = mongoTemplate.findOne(query, FavoriteVocabularies.class);
       
        return result;
    }


    public FavoriteVocabularies addFavoriteVocabulariesToUser(FavoriteVocabularies test) {
        return favoriteVocabularyRepository.save(test);
    }


    public List<FavoriteVocabularies> getFavoriteVocabulariesByUser(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        List<FavoriteVocabularies> result = mongoTemplate.find(query, FavoriteVocabularies.class);
        return result;
    }


    public void deleteFavoriteVocabulary(String id) {
        favoriteVocabularyRepository.deleteById(id);
    }
}
