package com.example.backenddictionnary.backend_dictionary.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.backenddictionnary.backend_dictionary.models.UnitHasVocabulary;

@Repository
public interface UnitHasVocabularyRepository extends MongoRepository<UnitHasVocabulary,String> {
    
}
