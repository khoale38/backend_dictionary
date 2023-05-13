package com.example.backenddictionnary.backend_dictionary.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backenddictionnary.backend_dictionary.models.UnitHasVocabulary;
import com.example.backenddictionnary.backend_dictionary.service.UnitHasVocabularyService;

@RestController
@RequestMapping("/unithasvocabulary")
public class UnitHasVocabularyController {
    @Autowired
    private UnitHasVocabularyService unitHasVocabularyService;

    @GetMapping()
    public List<UnitHasVocabulary> getAllUnitHasVocabulary() {
        return unitHasVocabularyService.getAllUnitHasVocabulary();
    }

    @GetMapping("/byid/{id}")
    public List<UnitHasVocabulary> getUnitHasVocabulariesByUnitId(@PathVariable String id) {
        return unitHasVocabularyService.getUnitHasVocabularyById(id);
    }

    @PostMapping()
    public UnitHasVocabulary addVocabularyToUnit(@RequestBody UnitHasVocabulary User) {
        return unitHasVocabularyService.addVocabularyToUnit(User);
    }
}
