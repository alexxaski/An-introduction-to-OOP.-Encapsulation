package org.skypro.skyshop.article;
import org.skypro.skyshop.notFoundAndSedrch.Searchable;

public class Article implements Searchable {
    private String title;
    private String content;
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String getSearchTerm() {
        return title + " " + content;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getObjectName() {
        return title;
    }
}