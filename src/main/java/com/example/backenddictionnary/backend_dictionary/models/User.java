package com.example.backenddictionnary.backend_dictionary.models;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
    @Id
    private Id id;
    private String email;
    private String password;
    private String userName;
    private Date dateOfBirth;
    private FavoriteVocabularies favoriteVocabularies;
    private FavoriteUnit favoriteUnit;
    private TestHistory testHistory;
    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public FavoriteVocabularies getFavoriteVocabularies() {
        return favoriteVocabularies;
    }

    public void setFavoriteVocabularies(FavoriteVocabularies favoriteVocabularies) {
        this.favoriteVocabularies = favoriteVocabularies;
    }

    public FavoriteUnit getFavoriteUnit() {
        return favoriteUnit;
    }

    public void setFavoriteUnit(FavoriteUnit favoriteUnit) {
        this.favoriteUnit = favoriteUnit;
    }

    public TestHistory getTestHistory() {
        return testHistory;
    }

    public void setTestHistory(TestHistory testHistory) {
        this.testHistory = testHistory;
    }

}
