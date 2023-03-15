package com.example.backenddictionnary.backend_dictionary.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testhistory")
public class TestHistory {
    @Id
    private String id;
    private String userId;
    private String testId;
    private int totalPoint;
    private Date testDate;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getTestId() {
        return testId;
    }
    public void setTestId(String testId) {
        this.testId = testId;
    }
    public int getTotalPoint() {
        return totalPoint;
    }
    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }
    public Date getTestDate() {
        return testDate;
    }
    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }
}
