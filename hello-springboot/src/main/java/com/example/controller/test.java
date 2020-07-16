package com.example.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
public class test {
           @RequestMapping("/haha")
           public String test() {
        	   return "springboot hello!!!!!";
           }
}
