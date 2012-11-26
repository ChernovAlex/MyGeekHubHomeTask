package com.example.parse.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Vector;


public class ArticleCollection extends Vector {

    public static ArticleCollection fromJson(JSONObject data) throws JSONException {
        ArticleCollection collection = new ArticleCollection();

        JSONObject jsonFeed = data.getJSONObject("feed");
        JSONArray jsonEntry = jsonFeed.getJSONArray("entry");

        for (int i = 0; i < jsonEntry.length(); i++) {
            collection.add(new Article(jsonEntry.getJSONObject(i)));
        }
        return collection;
    }
}
