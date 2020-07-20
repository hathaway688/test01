package com.sitech.mybatis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.naming.StringManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sitech.mybatis.dao.Music;
import com.sitech.mybatis.service.MusicService;

@Controller
@RequestMapping("/music")
public class MusicController {
	@Autowired
	private MusicService musicservice;
    
	@RequestMapping("/insert")
	public String insertMusic(HttpServletRequest request,Model model) {
	Music music =new Music();
	music.setName(request.getParameter("mname"));
	music.setSinger(request.getParameter("msinger"));
	music.setPicture(request.getParameter("mp3"));
	music.setMp3(request.getParameter("picture"));
	musicservice.insertMusic(music);
	return "/before/insert";
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public Integer deleteMusic(@RequestParam("codevalue") Integer id) {		
	try {
		return  musicservice.deleteMusic(id);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	return 0;
	}
	
	@RequestMapping("/select")
	public Music selectMusic(int id) {
	Music music =musicservice.selectMusic(id);
	System.out.println(music.toString());
	return musicservice.selectMusic(id)	;
	/*	return "successful!";*/
	}
	
	@RequestMapping("/selectall")
	public String selectAllMusic(Model model) {
	/*return musicservice.selectAllMusic();*/
	List<Music> list =musicservice.selectAllMusic();
	int i;
/*	for(i=0;i<list.size();i++)
		System.out.println(list.get(i).toString());*/
	model.addAttribute("aa",musicservice.selectAllMusic());
	return "/before/selectall";
	}
	
	@RequestMapping("/update")
	public String updateMusi(int id) {
		System.out.println(id+"aaaaaa");
	return "/before/insert";
	}
	
	@RequestMapping("toInsert")
	public String toInsert() {
		return "/before/insert";
	}
	
	@RequestMapping("/test")
	public String test(){
		return "/before/homepage";
	}
	
    @RequestMapping("login")
    public String login() {
    	return "/before/login";
    }
    
}
