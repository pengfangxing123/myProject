package com.jncj.myProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/center")
public class CenterController {
	/** 跳转到首页*/
	@RequestMapping("/index.do")
	public String toIndex(){
		return "index";
	}

	@RequestMapping("/top.do")
	public String toTop(){
		return "top";
	}
	
	@RequestMapping("/main.do")
	public String toMain(){
		return "main";
	}
	
	@RequestMapping("/left.do")
	public String toLeft(){
		return "left";
	}
	
	@RequestMapping("/right.do")
	public String toRight(){
		return "right";
	}
}
