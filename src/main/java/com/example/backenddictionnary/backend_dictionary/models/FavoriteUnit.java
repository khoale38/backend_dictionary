package com.example.backenddictionnary.backend_dictionary.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "favoriteUnit")
public class FavoriteUnit {
    @Id
    private String id;
    private String userId;
    private List<String> favoriteUnit;
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
    public List<String> getFavoriteUnit() {
        return favoriteUnit;
    }
    public void setFavoriteUnit(List<String> favoriteUnit) {
        this.favoriteUnit = favoriteUnit;
    }
}
