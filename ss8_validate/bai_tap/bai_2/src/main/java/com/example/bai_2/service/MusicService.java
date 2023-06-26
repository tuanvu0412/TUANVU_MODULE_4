package com.example.bai_2.service;

import com.example.bai_2.model.Music;
import com.example.bai_2.repo.IMusicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService{
    @Autowired
    private IMusicRepo musicRepo;

    @Override
    public List<Music> getMusicList() {
        return musicRepo.findAll();
    }

    @Override
    public void add(Music music) {
        musicRepo.save(music);
    }

    @Override
    public void edit(Music music) {
        musicRepo.save(music);
    }

    @Override
    public Music findId(int id) {
        for (int i = 0; i < getMusicList().size() ; i++) {
            if(getMusicList().get(i).getId()==id){
                return getMusicList().get(i);
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        musicRepo.getBlogByIdAndFlagDeleteIsFalse(id);
    }
}

