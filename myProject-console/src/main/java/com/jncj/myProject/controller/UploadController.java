package com.jncj.myProject.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.dubbo.common.json.JSONObject;

@Controller
@RequestMapping(value="/upload")
public class UploadController {
	/**
	 * 图片上传
	 * @param pic
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/uploadPic.do",method=RequestMethod.POST)
	public void uploadPic(MultipartFile pic,HttpServletRequest request,HttpServletResponse response){
		try {
			if(pic!=null&&pic.getSize()>0){
				//改名
				String filename = pic.getOriginalFilename();
				String extension = FilenameUtils.getExtension(filename);//获取后缀
				String uuid = UUID.randomUUID().toString().replace("-", "");
				String newName=uuid+"."+extension;
				
				//文件上传
				String imagUrl="\\upload\\"+newName;
				String realPath = request.getServletContext().getRealPath("");
				String url=realPath+realPath;//图片路径
				JSONObject jsonObject=new JSONObject();
				jsonObject.put("url",url);//图片回写
				jsonObject.put("imagUrl", imagUrl);//保存图片的url
				response.setContentType("application/json;charset=UTF-8");
				response.getWriter().write(jsonObject.toString());
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
