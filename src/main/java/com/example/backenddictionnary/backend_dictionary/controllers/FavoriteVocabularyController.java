package com.example.backenddictionnary.backend_dictionary.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backenddictionnary.backend_dictionary.models.FavoriteVocabularies;
import com.example.backenddictionnary.backend_dictionary.service.FavoriteVocabularyService;

@RestController
@RequestMapping("/favoritevocabulary")
public class FavoriteVocabularyController {
    @Autowired
    private FavoriteVocabularyService favoriteVocabularyService;

    @GetMapping()
    public List<FavoriteVocabularies> getAllFavoriteVocabularies() {
        return favoriteVocabularyService.getAllFavoriteVocabularies();
    }
    @PostMapping()
    public FavoriteVocabularies addFavoriteVocabulariesToUser(@RequestBody FavoriteVocabularies option) {
        return favoriteVocabularyService.addFavoriteVocabulariesToUser(option);
    }

    @GetMapping("/{userid}")
    public List<FavoriteVocabularies> getFavoriteVocabulariesByUser(@PathVariable String userid) {
        return favoriteVocabularyService.getFavoriteVocabulariesByUser(userid);
    }

    @DeleteMapping("/{userid}")
    public void deleteFavoriteVocabulary(@PathVariable String userid) {
         favoriteVocabularyService.deleteFavoriteVocabulary(userid);
    }
}
