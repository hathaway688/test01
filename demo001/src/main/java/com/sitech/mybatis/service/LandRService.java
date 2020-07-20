package com.sitech.mybatis.service;

import java.util.List;

import org.springframework.ui.Model;

import com.sitech.mybatis.dao.User;

public interface LandRService {

	public String login(String email,String password,Model model);
	
	
}
