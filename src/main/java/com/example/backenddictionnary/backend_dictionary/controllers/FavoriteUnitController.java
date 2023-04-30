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

import com.example.backenddictionnary.backend_dictionary.models.FavoriteUnit;

import com.example.backenddictionnary.backend_dictionary.service.FavoriteUnitService;

@RestController
@RequestMapping("/favoriteunit")
public class FavoriteUnitController {
    @Autowired
    private FavoriteUnitService favoriteUnitService;

    @GetMapping()
    public List<FavoriteUnit> getAllFavoriteUnit() {
        return favoriteUnitService.getAllFavoriteUnit();
    }
    @PostMapping()
    public FavoriteUnit addFavoriteUnitToUser(@RequestBody FavoriteUnit unit) {
        return favoriteUnitService.addFavoriteUnitToUser(unit);
    }

    @GetMapping("/{userid}")
    public List<FavoriteUnit> getFavoriteUnitByUser(@PathVariable String userid) {
        return favoriteUnitService.getFavoriteUnitByUser(userid);
    }

    @DeleteMapping("/{id}")
    public void deleteFavoriteVocabulary(@PathVariable String id) {
        favoriteUnitService.deleteFavoriteUnit(id);
    }
    
}
