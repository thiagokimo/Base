package io.kimo.base.example.data;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String description;
    private String course;
    private String imageUrl;

    public Student(String name, String description, String imageUrl, String course) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }
}
