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

    @GetMapping("/{id}")
    public Test getTestById(@PathVariable String id) {
        return testService.getTestById(id);
    }


    @PostMapping()
    public Test addTest(@RequestBody Test User) {
        return testService.addTest(User);
    }

     @PostMapping("/{id}")
    public Test editTest(@PathVariable String id,@RequestBody Test test) {
        return testService.editTest(test,id);
    }

    @PostMapping("addQuestion/{testid}/{questionid}")
    public Test addQuestionToTest(@PathVariable String testid,@PathVariable String questionid) {
        return testService.addQuestionToTest(testid,questionid);
    }

    @PostMapping("removeQuestion/{testid}/{questionid}")
    public Test removeQuestionFromTest(@PathVariable String testid,@PathVariable String questionid) {
        return testService.removeQuestionfromTest(testid,questionid);
    }


    @DeleteMapping("/{id}")
    public void deleteTest(@PathVariable String id) {
        testService.deleteTest(id);
    }
}
