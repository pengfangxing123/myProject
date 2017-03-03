package com.jncj.myProject.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jncj.myProject.dao.product.BrandMapper;
import com.jncj.myProject.pojo.page.Pagination;
import com.jncj.myProject.pojo.product.Brand;

@Service("brandService")
public class BrandServiceImp implements BrandService {
	@Autowired
	private BrandMapper brandMapper;
	/**
	 * 分页查询品牌
	 * @param name
	 * @param isDisplay
	 * @return
	 */
	public Pagination queryBrand(String name, String isDisplay,int pageNo)throws Exception {
		List<Brand> brands=new ArrayList<Brand>();
		StringBuilder builder=new StringBuilder();
		Brand parm = new Brand();
		if(name!=null&&!name.equals("")){
			parm.setName(name);
			builder.append("name=").append(name);
		}	
		if(isDisplay!=null&&!isDisplay.equals("")){
			parm.setIsDisplay(Integer.parseInt(isDisplay));
			builder.append("&isDisplay=").append(isDisplay);
		}
		parm.setPageSize(4);//每页数
		parm.setPageNo(Pagination.cpn(pageNo));//当前页
		int total=brandMapper.queryBrandSize(parm);//总页数
		brands = brandMapper.queryBrand(parm);//得到所有品牌结果集
		Pagination pagination = new Pagination(pageNo, 4, total, brands);
		String url="/brand/list";
		pagination.pageView(url, builder.toString());
		return pagination;
	}
	
	/**
	 * 根据id 查询品牌
	 * @param id
	 * @return
	 */
	public Brand queryBrandById(Long id) throws Exception{
		Map param=new HashMap();
		param.put("id", id);
		Brand brand=this.brandMapper.queryBrandById(param);
		return brand;
	}

	/**
	 * 更新品牌
	 * @param brand
	 */
	public void updateBrand(Brand brand) throws Exception {
		Long id = brand.getId();
		Brand queryBrandById=null;
		if(id!=null&&!id.equals("")){
			queryBrandById = this.queryBrandById(id);
		}
		//添加品牌
		if(queryBrandById!=null){
			this.brandMapper.updateBrand(brand);
		}else{
			//更新品牌
			this.brandMapper.addBrand(brand);
		}	
	}
	

}
