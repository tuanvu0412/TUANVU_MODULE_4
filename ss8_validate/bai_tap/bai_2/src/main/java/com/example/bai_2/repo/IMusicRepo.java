package com.example.bai_2.repo;

import com.example.bai_2.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMusicRepo extends JpaRepository<Music,Integer> {
    Music getBlogByIdAndFlagDeleteIsFalse(int id);
}
