package com.jncj.myProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
	/** list跳转*/
	@RequestMapping("/list")
	public String tolist(){
		return "product/list";
	}
}
