package com.example.backenddictionnary.backend_dictionary.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backenddictionnary.backend_dictionary.models.Option;
import com.example.backenddictionnary.backend_dictionary.service.OptionService;

@RestController
@RequestMapping("/option")
public class OptionController {
    @Autowired
    private OptionService optionService;

    @GetMapping("/{id}")
    public Option getOptionById(@PathVariable String id) {
        return optionService.getOptionById(id);
    }

    @GetMapping()
    public List<Option> getAllOption() {
        return optionService.getAllOption();
    }

    @PostMapping()
    public Option addOption(@RequestBody Option option) {
        return optionService.addOption(option);
    }

    @PutMapping("/{id}")
    public Option editQuestion(@PathVariable String id, @RequestBody Option option) {
        return optionService.editOption(option, id);
    }

}
