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

import com.example.backenddictionnary.backend_dictionary.models.TestHistory;
import com.example.backenddictionnary.backend_dictionary.service.TestHistoryService;

@RestController
@RequestMapping("/testhistory")
public class TestHistoryController {
    @Autowired
    private TestHistoryService testHistoryService;

    @GetMapping()
    public List<TestHistory> getAllTest() {
        return testHistoryService.getAllTestHistory();
    }

    @PostMapping()
    public TestHistory addTest(@RequestBody TestHistory User) {
        return testHistoryService.addTestHistory(User);
    }

    @GetMapping("/{userId}")
    public List<TestHistory> getTestHistoryByUser(@PathVariable String userId) {
        return testHistoryService.getTestHistoryByUser(userId);
    }


    @DeleteMapping("/{id}")
    public void deleteTest(@PathVariable String id) {
        testHistoryService.deleteTest(id);
    }
}
