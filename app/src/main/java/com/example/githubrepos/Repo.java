package com.example.githubrepos;

import com.google.gson.annotations.SerializedName;

public class Repo {
    @SerializedName("name")
    private String name;

    public Repo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
