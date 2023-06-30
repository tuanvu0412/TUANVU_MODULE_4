package com.example.bai_tap.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class BlogTypeDto {
    private int id;
    @NotBlank
    @Pattern(regexp = "^[^@;,.\\-=+!#$%&<>]{1,800}$",message = "không được chứa kí tự đặc biệt")
    private String name;
    private boolean flagDelete=false;
    public BlogTypeDto() {
    }

    public BlogTypeDto(int id, String name, boolean flagDelete) {
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
