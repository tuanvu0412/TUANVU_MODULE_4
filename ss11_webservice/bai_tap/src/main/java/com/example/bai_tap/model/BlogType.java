package com.example.bai_tap.model;

import javax.persistence.*;

@Entity
@Table(name="blogTypes")
public class BlogType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    private boolean flagDelete=false;
    public BlogType() {
    }

    public BlogType(int id, String name, boolean flagDelete) {
        this.id = id;
        this.name = name;
        this.flagDelete=flagDelete;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdType() {
        return id;
    }

    public void setIdType(int id) {
        this.id = id;
    }

    public boolean isFlagIsDelete() {
        return flagDelete;
    }

    public void setFlagIsDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }
}
