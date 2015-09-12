package io.kimo.base.domain.example.entity;

import io.kimo.base.domain.BaseEntity;

public class ExampleEntity extends BaseEntity {

    private String name;
    private String title;

    public ExampleEntity(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }
}
