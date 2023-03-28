package com.example.backenddictionnary.backend_dictionary.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backenddictionnary.backend_dictionary.models.Question;
import com.example.backenddictionnary.backend_dictionary.models.Test;
import com.example.backenddictionnary.backend_dictionary.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping()
    public List<Test> getAllTest() {
        return testService.getAllTest();
    }

    @PostMapping()
    public Test addTest(@RequestBody Test User) {
        return testService.addTest(User);
    }

    @PostMapping("addQuestion/{id}")
    public Test addQuestionToTest(@PathVariable String id,@RequestBody Question test) {
        return testService.addQuestion(test,id);
    }
}
