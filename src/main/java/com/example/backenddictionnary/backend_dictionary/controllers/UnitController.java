package com.example.backenddictionnary.backend_dictionary.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backenddictionnary.backend_dictionary.models.Unit;
import com.example.backenddictionnary.backend_dictionary.service.UnitService;

@RestController
@RequestMapping("/unit")
public class UnitController {
    @Autowired
    private UnitService UnitService;
    @GetMapping()
    public List<Unit> getAllUnits() {
        return UnitService.getAllUnit();
    }

    @GetMapping("/byname/{name}")
    public Unit getUnitByWord(@PathVariable String name) {
        return UnitService.getUnitByName(name);
    }

    @PutMapping("/byname/{name}")
    public Unit updateUnit(@PathVariable String name,@RequestBody Unit Unit) {
        return UnitService.updateUnit(name,Unit);
    }

    @PostMapping()
    public Unit addUnit(@RequestBody Unit Unit) {
        return UnitService.addUnit(Unit);
    }

    @DeleteMapping("/byword/{word}")
    public void deleteUnit(@PathVariable String word) {
        UnitService.deleteUnit(word);
    }

}
