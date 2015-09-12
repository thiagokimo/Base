package io.kimo.base.example.mvp.model;

import io.kimo.base.presentation.mvp.BaseModel;

public class ExampleModel extends BaseModel {
    private String name;
    private String profession;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
