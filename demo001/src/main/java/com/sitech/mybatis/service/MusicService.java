package com.sitech.mybatis.service;

import java.util.List;

import com.sitech.mybatis.dao.Music;

public interface MusicService {
     void insertMusic(Music music);
     Integer deleteMusic(Integer id);
     Music selectMusic(int id);
     List<Music> selectAllMusic();
     void updateMusic(Music music);
}
