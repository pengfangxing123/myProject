package com.jncj.myProject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jncj.myProject.pojo.page.Pagination;
import com.jncj.myProject.pojo.product.Brand;
import com.jncj.myProject.service.BrandService;

@Controller
@RequestMapping("/brand")
public class BrandController {
	/** 注入业务bean*/
	@Autowired
	private BrandService brandService;
	
	/**
	 * 查询和品牌
	 * @param name
	 * @param isDisplay
	 * @return
	 */
	@RequestMapping(value="/list.do")
	public ModelAndView queryBrand(String name,String isDisplay,@RequestParam(value="pageNo",defaultValue="0")int pageNo,HttpServletRequest request){
		ModelAndView mv = new ModelAndView("/brand/list");
		try {
			//条件回写用
			if(name!=null&&!name.equals("")) mv.addObject("name", name);
			if(isDisplay!=null&&!isDisplay.equals("")) mv.addObject("isDisplay", isDisplay);
			
			Pagination brands = brandService.queryBrand(name,isDisplay,pageNo);
			mv.addObject("brands", brands);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return mv;
	};
	
	/**
	 * 编辑品牌
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/edit.do",method=RequestMethod.GET)
	public ModelAndView editBrand(Long id){
		ModelAndView mv = new ModelAndView("/brand/edit");
		try {
			Brand brand=this.brandService.queryBrandById(id);
			mv.addObject(brand);
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 更新品牌
	 * @param brand
	 * @return
	 */
	@RequestMapping(value="/update.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateBrand(Brand brand){
		Map<String,Object> resultMap = new HashMap<String, Object>();  
		try {
			this.brandService.updateBrand(brand);
			resultMap.put("result","1");
			if(brand.getId()==null||brand.getId().equals("")){
				resultMap.put("result","3");	
			}		
		} catch (Exception e) {
			resultMap.put("result","2");
			e.printStackTrace();	
		}
		return resultMap;
	}
	
	/**
	 * 添加品牌
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/add.do",method=RequestMethod.GET)
	public String addBrand(){
		return "/brand/edit";
	}
}
