package com.example.backenddictionnary.backend_dictionary.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "vocabulary")
public class Vocabulary {
    @Id
    private String id;
    private String type;
    private String word;
    private String hint;
    private String phonetics;
    private String pronouce;
    private String image;
    private String meaning;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public String getHint() {
        return hint;
    }
    public void setHint(String hint) {
        this.hint = hint;
    }
    public String getPhonetics() {
        return phonetics;
    }
    public void setPhonetics(String phonetics) {
        this.phonetics = phonetics;
    }
    public String getPronouce() {
        return pronouce;
    }
    public void setPronouce(String pronouce) {
        this.pronouce = pronouce;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getMeaning() {
        return meaning;
    }
    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

}
