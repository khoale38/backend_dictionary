package com.example.backenddictionnary.backend_dictionary.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "favoritevocabulary")
public class FavoriteVocabularies {
    @Id
    private String id;
    private String userId;
    private List<Vocabulary> favoriteVocabularies;

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

    public List<Vocabulary> getFavoriteVocabularies() {
        return favoriteVocabularies;
    }

    public void setFavoriteVocabularies(List<Vocabulary> favoriteVocabularies) {
        this.favoriteVocabularies = favoriteVocabularies;
    }
}
