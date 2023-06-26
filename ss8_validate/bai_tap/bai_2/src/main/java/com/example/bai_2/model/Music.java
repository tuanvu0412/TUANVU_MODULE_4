package com.example.bai_2.model;

import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import javax.persistence.*;

@Entity
@Table(name="musics")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nameOfTheSong;
    private String nameOfSingers;
    private String kindOfMusic;
    private boolean FlagDelete=false;

    public Music() {
    }

    public Music(int id, String nameOfTheSong, String nameOfSingers, String kindOfMusic, boolean FlagDelete) {
        this.id = id;
        this.nameOfTheSong = nameOfTheSong;
        this.nameOfSingers = nameOfSingers;
        this.kindOfMusic = kindOfMusic;
        this.FlagDelete = FlagDelete;
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

    public boolean isDelete() {
        return FlagDelete;
    }

    public void setDelete(boolean delete) {
        FlagDelete = delete;
    }
}
