package com.sitech.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitech.mybatis.dao.Music;
import com.sitech.mybatis.mapper.MusicMapper;

@Service
public class MusicServiceImpl implements MusicService{
    @Autowired
    private MusicMapper musicmapper;
    
	@Override
	public void insertMusic(Music music) {
		 musicmapper.insertMusic(music);
	}

	@Override
	public Integer deleteMusic(Integer id) {
		return musicmapper.deleteMusic(id);
	}

	@Override
	public Music selectMusic(int id) {
		
		return musicmapper.selectMusic(id);
	}

	@Override
	public List<Music> selectAllMusic() {
		return musicmapper.selectAllMusic();
	}

	@Override
	public void updateMusic(Music music) {
		musicmapper.updateMusic(music);
	}

}
