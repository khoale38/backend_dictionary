package com.example.backenddictionnary.backend_dictionary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.backenddictionnary.backend_dictionary.models.Vocabulary;
import com.example.backenddictionnary.backend_dictionary.repository.VocabularyRepository;

@Service
public class VocabularyService {
    @Autowired
    private VocabularyRepository VocabularyRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Vocabulary> getAllVocabulary() {
        return VocabularyRepository.findAll();
    }

    public Vocabulary getVocabularyByWord(String word) {
        Query query = new Query();
        query.addCriteria(Criteria.where("word").is(word));
        List<Vocabulary> result = mongoTemplate.find(query, Vocabulary.class);
        if (result.size() == 0)
            return null;
        else
            return result.get(0);

    }

    public Vocabulary addVocabulary(Vocabulary Vocabulary) {
        Vocabulary findWord = getVocabularyByWord(Vocabulary.getWord());
        if (findWord != null)
            return findWord;
        else
            return VocabularyRepository.save(Vocabulary);
    }

    public Vocabulary updateVocabulary(String word, Vocabulary Vocabulary) {
        Vocabulary existingVocabulary = getVocabularyByWord(Vocabulary.getWord());

        if (existingVocabulary != null) {
            existingVocabulary
                    .setWord(Vocabulary.getWord() != null ? Vocabulary.getWord() : existingVocabulary.getWord());
            existingVocabulary
                    .setHint(Vocabulary.getHint() != null ? Vocabulary.getHint() : existingVocabulary.getHint());
            existingVocabulary.setMeaning(
                    Vocabulary.getMeaning() != null ? Vocabulary.getMeaning() : existingVocabulary.getMeaning());
            existingVocabulary.setPhonetics(
                    Vocabulary.getPhonetics() != null ? Vocabulary.getPhonetics() : existingVocabulary.getPhonetics());
            existingVocabulary.setPronouce(
                    Vocabulary.getPronouce() != null ? Vocabulary.getPronouce() : existingVocabulary.getPronouce());
            existingVocabulary
                    .setImage(Vocabulary.getImage() != null ? Vocabulary.getImage() : existingVocabulary.getImage());
            return VocabularyRepository.save(existingVocabulary);
        }
        return null;

    }

    public void deleteVocabulary(String word) {
        Vocabulary existingVocabulary = getVocabularyByWord(word);
        if (existingVocabulary == null) {
        } else
            VocabularyRepository.deleteById(existingVocabulary.getId());
    }
}
