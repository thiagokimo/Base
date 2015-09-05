package io.kimo.base.v7.example.presentation.mvp.model;

import io.kimo.base.presentation.mvp.BaseModel;

public class ExampleModel extends BaseModel {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
