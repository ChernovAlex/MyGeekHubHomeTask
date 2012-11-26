package com.example.parse.json;

import org.json.JSONObject;


public class Article {

    private String title;
    private String description;

    public Article() {}

    public Article(JSONObject data) {
        setTitle(data.optJSONObject("title").optString("$t"));
        setDescription(data.optJSONObject("content").optString("$t"));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
