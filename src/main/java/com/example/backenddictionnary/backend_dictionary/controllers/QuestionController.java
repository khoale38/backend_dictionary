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


    @GetMapping()
    public List<Question> getAllQuestion() {
        return questionService.getAllQuestion();
    }
    
    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable String id) {
        return questionService.getQuestionById(id);
    }

    @PostMapping()
    public Question addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @PutMapping("/{id}")
    public Question editQuestion(@PathVariable String id, @RequestBody Question question) {
        return questionService.editQuestion(question, id);
    }

    @PostMapping("addOption/{questionid}/{optionid}")
    public Question addOptiontoQuestion(@PathVariable String questionid, @PathVariable String optionid) {
        return questionService.addOptionToQuestion(questionid, optionid);
    }

    @PostMapping("removeOption/{questionid}/{optionid}")
    public Question removeOptionFromQuestion(@PathVariable String questionid, @PathVariable String optionid) {
        return questionService.removeOptionfromQuestion(questionid, optionid);
    }
}
