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

import com.example.backenddictionnary.backend_dictionary.models.Question;
import com.example.backenddictionnary.backend_dictionary.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;


    @PostMapping()
    public Question addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }


    //TODO: Currently: this question and test is base on 2 diff schema so edit is not working
    @PutMapping("/{id}")
    public Question editQuestion(@PathVariable String id,@RequestBody Question question) {
        return questionService.editQuestion(question, id);
    }


}
