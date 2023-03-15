package com.example.backenddictionnary.backend_dictionary.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.backenddictionnary.backend_dictionary.models.Vocabulary;

@Repository
public interface VocabularyRepository extends MongoRepository<Vocabulary, String> {
    
}
