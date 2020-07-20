package com.sitech.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sitech.mybatis.service.LandRService;

@Controller
@RequestMapping("/LandR")
public class LoginAndRegisterController {
    @Autowired
	public LandRService landrservice ; 
     
	@RequestMapping("toRegister")
	public String login() {
		return "/before/register";
	}
	
	@RequestMapping("/login")
	public String login(String email,String password,Model model) {
		return landrservice.login(email, password, model); 
	}
	
}

