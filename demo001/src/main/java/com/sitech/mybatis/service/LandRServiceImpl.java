package com.sitech.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model; 

import com.sitech.mybatis.dao.User;
import com.sitech.mybatis.mapper.LandRMapper;

@Service
public class LandRServiceImpl implements LandRService{

	@Autowired
	private LandRMapper landrmapper;
	
	@Override
	public String login(String email, String password ,Model model) {
		// TODO Auto-generated method stub
        User user =null;
        List<User> list= landrmapper.login(email, password);
        if(list.size() > 0) {
			user = list.get(0);
		}
        if(user != null) {
        	model.addAttribute("user", user);
			return "/before/homepage";
		}else {
			model.addAttribute("msg", "用户名或密码错误！");
			return "/before/login";
		}
	}

	
}
