package com.bookstore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "Author")
public class Author {
    @Id
    private Long id;

    private String name;
    private String genre;
    private int age;

    public static Author createAuthor(Long id, String name, String genre, int age) {
        Author author = new Author();
        author.id = id;
        author.name = name;
        author.genre = genre;
        author.age = age;
        return author;
    }

    public void changeAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", age=" + age +
                '}';
    }
}
