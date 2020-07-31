package com.si_tech.bdmp.controller;

import java.text.DateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.si_tech.bdmp.service.HostInfoService;

@Controller
public class HelloController {

	@Autowired
	HostInfoService hostinfoservice;
	
	@RequestMapping("/homepage")
	public String hello(Model model,HttpSession session) {
		//model.addAttribute("test1", DateFormat.getDateTimeInstance().format(new Date()));
		//session.setAttribute("test2", "is a test ..");
		model.addAttribute("hosts",hostinfoservice.getAllHost());	
		return "Homepage";
	}
}
