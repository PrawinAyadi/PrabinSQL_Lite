package com.example.prabinsql_lite.model;

public class Word {
    private int id;
    private String Word, Meaning;

    public Word(int id, String word, String meaning) {
        this.id = id;
        Word = word;
        Meaning = meaning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return Word;
    }

    public void setWord(String word) {
        Word = word;
    }

    public String getMeaning() {
        return Meaning;
    }

    public void setMeaning(String meaning) {
        Meaning = meaning;
    }


}
