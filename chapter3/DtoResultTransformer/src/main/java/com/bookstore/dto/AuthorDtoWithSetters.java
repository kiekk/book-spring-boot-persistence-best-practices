package com.bookstore.dto;

public class AuthorDtoWithSetters {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "AuthorDto{" + "name=" + name + ", age=" + age + '}';
    }
}
