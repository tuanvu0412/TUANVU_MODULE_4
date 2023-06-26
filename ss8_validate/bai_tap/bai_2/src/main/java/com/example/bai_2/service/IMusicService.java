package com.example.bai_2.service;

import com.example.bai_2.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> getMusicList();
    void add(Music music);
    void edit(Music music);
    Music findId(int id);
    void delete(int id);
}
