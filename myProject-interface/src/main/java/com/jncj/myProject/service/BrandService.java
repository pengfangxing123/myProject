package com.jncj.myProject.service;

import java.io.Serializable;
import java.util.List;

import com.jncj.myProject.pojo.page.Pagination;
import com.jncj.myProject.pojo.product.Brand;

public interface BrandService extends Serializable {
	/**
	 * 查询品牌
	 * @param name
	 * @param isDisplay
	 * @return
	 * @throws Exception 
	 */
	public Pagination queryBrand(String name, String isDisplay,int pageNo) throws Exception;

	/**
	 * 根据id 查询品牌
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public Brand queryBrandById(Long id) throws Exception;

	/**
	 * 更新品牌
	 * @param brand
	 */
	public void updateBrand(Brand brand)throws Exception;
}
