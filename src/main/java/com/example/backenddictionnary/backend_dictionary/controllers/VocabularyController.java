package com.example.backenddictionnary.backend_dictionary.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backenddictionnary.backend_dictionary.models.Vocabulary;
import com.example.backenddictionnary.backend_dictionary.service.VocabularyService;

@RestController
@RequestMapping("/vocabulary")
public class VocabularyController {
    @Autowired
    private VocabularyService VocabularyService;

    @GetMapping()
    public List<Vocabulary> getAllVocabularys() {
        return VocabularyService.getAllVocabulary();
    }

    @GetMapping("/byword/{word}")
    public Vocabulary getVocabularyByWord(@PathVariable String word) {
        return VocabularyService.getVocabularyByWord(word);
    }

    @PutMapping("/byword/{word}")
    public Vocabulary updateVocabularyByWord(@PathVariable String word, @RequestBody Vocabulary vocabulary) {
        return VocabularyService.updateVocabulary(word, vocabulary);
    }

    @PostMapping()
    public Vocabulary addVocabulary(@RequestBody Vocabulary vocabulary) {
        return VocabularyService.addVocabulary(vocabulary);
    }

    @DeleteMapping("/byword/{word}")
    public void deleteVocabulary(@PathVariable String word) {
        VocabularyService.deleteVocabulary(word);
    }
}
