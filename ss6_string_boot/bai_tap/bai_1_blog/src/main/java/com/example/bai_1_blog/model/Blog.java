package com.example.bai_1_blog.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String content;
    private LocalDate times;

    public Blog() {
    }

    public Blog(int id, String name, String content, LocalDate time) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.times = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getTimes() {
        return times;
    }

    public void setTimes(LocalDate times) {
        this.times = times;
    }
}
