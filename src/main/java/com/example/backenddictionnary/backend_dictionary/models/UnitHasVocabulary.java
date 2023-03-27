package com.example.backenddictionnary.backend_dictionary.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "unithasvocabulary")
public class UnitHasVocabulary {
    @Id
    private String id;
    private String unitId;
    private String vocabularyId;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUnitId() {
        return unitId;
    }
    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }
    public String getVocabularyId() {
        return vocabularyId;
    }
    public void setVocabularyId(String vocabularyId) {
        this.vocabularyId = vocabularyId;
    }
}
