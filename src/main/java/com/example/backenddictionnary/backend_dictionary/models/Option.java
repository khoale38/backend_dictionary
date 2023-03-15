package com.example.backenddictionnary.backend_dictionary.models;

import org.springframework.data.annotation.Id;

public class Option {
    @Id
    private String id;
    private String value;
    private boolean isCorrect;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public boolean isCorrect() {
        return isCorrect;
    }
    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
}
