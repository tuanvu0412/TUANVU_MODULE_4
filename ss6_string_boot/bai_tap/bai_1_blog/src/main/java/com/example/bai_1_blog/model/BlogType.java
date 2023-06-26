package com.example.bai_1_blog.model;

import javax.persistence.*;

@Entity
@Table(name="blogTypes")
public class BlogType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idType;
    private String name;

    private boolean flagIsDelete=false;
    public BlogType() {
    }

    public BlogType(int idType, String name,boolean flagIsDelete) {
        this.idType = idType;
        this.name = name;
        this.flagIsDelete=flagIsDelete;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public boolean isFlagIsDelete() {
        return flagIsDelete;
    }

    public void setFlagIsDelete(boolean flagIsDelete) {
        this.flagIsDelete = flagIsDelete;
    }
}
