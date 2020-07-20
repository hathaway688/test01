package com.sitech.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sitech.mybatis.controller.MusicController;

@SpringBootApplication
@MapperScan("com.sitech.mybatis.mapper")
public class SpringBootMybatisApplication {
   public static void main(String[] args) {
	   SpringApplication.run(SpringBootMybatisApplication.class, args);
	   /*MusicController musiccontroller = null;*/
	   /*System.out.println(musiccontroller.selectMusic(1));*/
   }
}
