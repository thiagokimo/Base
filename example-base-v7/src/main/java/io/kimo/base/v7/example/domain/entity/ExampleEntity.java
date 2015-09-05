package io.kimo.base.v7.example.domain.entity;

import io.kimo.base.domain.BaseEntity;

public class ExampleEntity extends BaseEntity {

    private String name;
    private int age;

    public ExampleEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
