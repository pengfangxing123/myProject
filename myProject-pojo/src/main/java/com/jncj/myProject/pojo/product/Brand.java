package com.jncj.myProject.pojo.product;

import java.io.Serializable;

/**
 * 
 * @ClassName: Brand
 * @Company: 
 * @Description: 品牌信息
 * @author 
 * @date 
 */
@SuppressWarnings("serial")
public class Brand implements Serializable{

		private Long id; 			// 品牌ID  bigint
		private String name; 		// 品牌名称
		private String description; // 描述
		private String imgUrl; 		// 图片URL
		private Integer sort; 		// 排序  越大越靠前   
		private Integer isDisplay; 	// 是否可用   0 不可用 1 可用
		
		/*public String getAllUrl(){ // 完整的图片地址
			return NewBabaSport.IMG_URL + this.imgUrl;
		}*/
		// part2：分页信息
		private Integer startRow; 	   // 起始行
		private Integer pageSize = 3;  // 每页显示的条数
		private Integer pageNo = 1;    // 当前页码
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getImgUrl() {
			return imgUrl;
		}
		public void setImgUrl(String imgUrl) {
			this.imgUrl = imgUrl;
		}
		public Integer getSort() {
			return sort;
		}
		public void setSort(Integer sort) {
			this.sort = sort;
		}
		public Integer getIsDisplay() {
			return isDisplay;
		}
		public void setIsDisplay(Integer isDisplay) {
			this.isDisplay = isDisplay;
		}
		
		
		/** 分页信息*/
		public Integer getStartRow() {
			return startRow;
		}
		public void setStartRow(Integer startRow) {
			this.startRow = startRow;
		}
		public Integer getPageSize() {
			return pageSize;
		}
		public void setPageSize(Integer pageSize) {
			this.startRow = (pageNo - 1) * pageSize; // startRow随着pageSize的改变而改变
			this.pageSize = pageSize;
		}
		public Integer getPageNo() {
			return pageNo;
		}
		public void setPageNo(Integer pageNo) {
			this.startRow = (pageNo - 1) * pageSize; // startRow随着pageNo的改变而改变
			this.pageNo = pageNo;
		}
		
}
