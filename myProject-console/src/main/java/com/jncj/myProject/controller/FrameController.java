package com.jncj.myProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/frame")
public class FrameController {
	/** 跳转到product_main页*/
	@RequestMapping("/product_main")
	public String toProduct_main(){
		return "frame/product_main";
	}
	
	@RequestMapping("/product_left")
	public String toProduct_left(){
		return "frame/product_left";
	}
}
