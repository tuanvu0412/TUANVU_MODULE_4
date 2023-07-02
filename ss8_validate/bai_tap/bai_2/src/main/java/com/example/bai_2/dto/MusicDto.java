package com.example.bai_2.dto;




import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDto implements Validator {
    private int id;
    @NotBlank
    @Size(max = 800)
    @Pattern(regexp = "^[^@;,.\\-=+!#$%&<>]{1,800}$",message = "không được chứa kí tự đặc biệt")
    private String nameOfTheSong;
    @NotBlank
    @Size(max = 300)
    @Pattern(regexp = "^[^@;,.\\-=+!#$%&<>]{1,800}$",message = "không được chứa kí tự đặc biệt")
    private String nameOfSingers;
    @NotBlank
    @Size(max = 1000)
    @Pattern(regexp = "^[^@;,.\\-=+!#$%&<>]{1,800}$",message = "không được chứa kí tự đặc biệt")
    private String kindOfMusic;
    private boolean flagDelete=false;

    public MusicDto() {

    }

    public MusicDto(int id, String nameOfTheSong, String nameOfSingers, String kindOfMusic, boolean flagDelete) {
        this.id = id;
        this.nameOfTheSong = nameOfTheSong;
        this.nameOfSingers = nameOfSingers;
        this.kindOfMusic = kindOfMusic;
        this.flagDelete=flagDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfTheSong() {
        return nameOfTheSong;
    }

    public void setNameOfTheSong(String nameOfTheSong) {
        this.nameOfTheSong = nameOfTheSong;
    }

    public String getNameOfSingers() {
        return nameOfSingers;
    }

    public void setNameOfSingers(String nameOfSingers) {
        this.nameOfSingers = nameOfSingers;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        flagDelete = flagDelete;
    }
}
