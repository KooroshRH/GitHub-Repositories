package com.example.githubrepos;

import com.google.gson.annotations.SerializedName;

public class Repo {
    @SerializedName("name")
    private String name;

    @SerializedName("language")
    private String language;

    public Repo(String name, String language) {
        this.name = name;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
