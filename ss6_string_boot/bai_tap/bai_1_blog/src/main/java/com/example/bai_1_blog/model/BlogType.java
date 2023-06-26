package com.example.bai_1_blog.model;

import javax.persistence.*;

@Entity
@Table(name="blogTypes")
public class BlogType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idType;
    private String name;

    public BlogType() {
    }

    public BlogType(int idType, String name) {
        this.idType = idType;
        this.name = name;
    }

    public int getId() {
        return idType;
    }

    public void setId(int idType) {
        this.idType=idType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
