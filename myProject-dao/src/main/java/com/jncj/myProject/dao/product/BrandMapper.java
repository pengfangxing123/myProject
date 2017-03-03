package com.jncj.myProject.dao.product;

import java.util.List;
import java.util.Map;

import com.jncj.myProject.pojo.product.Brand;

public interface BrandMapper {
	/**
	 * 查询品牌
	 * @param Brand 对象
	 * @return
	 */
	public List<Brand> queryBrand(Brand parm);
	
	/**
	 * 查询品牌总条数
	 * @param Brand 对象
	 * @return
	 */
	public int queryBrandSize(Brand parm);
	
	/**
	 * 根据Id查询品牌
	 * @param param
	 * @return
	 */
	public Brand queryBrandById(Map param);
	
	/**
	 * 更新品牌
	 * @param brand
	 */
	public void updateBrand(Brand brand);
	
	/**
	 * 添加品牌
	 * @param brand
	 */
	public void addBrand(Brand brand);
}
