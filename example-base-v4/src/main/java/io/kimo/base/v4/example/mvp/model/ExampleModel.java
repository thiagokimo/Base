package io.kimo.base.v4.example.mvp.model;

import io.kimo.base.presentation.mvp.BaseModel;

public class ExampleModel extends BaseModel {
    private String name;
    private String profession;
    private String backgroundUrl;

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

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }
}
