package com.example.prabinsql_lite;

public class Word {
    int id;
    String wordname, wordmeaning;

    public Word(int id, String wordname, String wordmeaning) {
        this.id = id;
        this.wordname = wordname;
        this.wordmeaning = wordmeaning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWordname() {
        return wordname;
    }

    public void setWordname(String wordname) {
        this.wordname = wordname;
    }

    public String getWordmeaning() {
        return wordmeaning;
    }

    public void setWordmeaning(String wordmeaning) {
        this.wordmeaning = wordmeaning;
    }
}
