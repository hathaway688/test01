package com.sitech.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sitech.mybatis.dao.Music;

@Mapper
public interface MusicMapper {
   @Insert("insert into musictable(id,mname,msinger,mpicture,mp3) values(null,#{name},#{singer},#{picture},#{mp3})")
   void insertMusic(Music music);
   
   @Delete("delete from musictable where id=#{id}")
   Integer deleteMusic(Integer id);
   
   @Select("select m.id,m.mname,m.msinger,m.mpicture,m.mp3 from musictable m where id =#{id}")
   @Results({
	   @Result(property="name",column="mname"),
	   @Result(property="singer",column="msinger"),
	   @Result(property="picture",column="mpicture"),
   })
  Music selectMusic(int id);
   
   @Select("select m.id,m.mname,m.msinger,m.mpicture,m.mp3 from musictable m")
   @Results({
	   @Result(property="name",column="mname"),
	   @Result(property="singer",column="msinger"),
	   @Result(property="picture",column="mpicture")   
   })
   List<Music> selectAllMusic();
   
   @Update("update musictable set mname=#{name},msinger=#{singer},mpicture=#{picture},mp3=#{mp3} where id=#{id}")
   void updateMusic(Music music);
}
