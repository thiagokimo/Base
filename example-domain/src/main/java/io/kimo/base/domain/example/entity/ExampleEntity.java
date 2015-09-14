package io.kimo.base.domain.example.entity;

import io.kimo.base.domain.BaseEntity;

public class ExampleEntity extends BaseEntity {

    private String name;
    private String title;
    private String imageUrl;

    public ExampleEntity(String name, String title, String imageUrl) {
        this.name = name;
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
