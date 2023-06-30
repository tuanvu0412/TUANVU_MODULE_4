package com.example.bai_tap.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    private LocalDate times;

    @Column(columnDefinition = "LONGTEXT")
    private String img;
    @ManyToOne
    @JoinColumn(name="id_type", nullable = false)
    private BlogType blogType;

    private boolean flagDelete = false;

    public Blog() {
    }

    public Blog(int id, String name, String content, LocalDate times, String img, boolean flagDelete,BlogType blogType) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.times = times;
        this.img = img;
        this.blogType=blogType;
        this.flagDelete = flagDelete;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public BlogType getBlogType() {
        return blogType;
    }

    public void setBlogType(BlogType blogType) {
        this.blogType = blogType;
    }
}
