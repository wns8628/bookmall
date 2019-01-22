package com.douzone.bookmall.vo;

import java.util.List;

import com.douzone.bookmall.dao.CategoryDao;

public class CategoryVo {
	private int no;
	private String name;
	
	public CategoryVo() {}
	
	public CategoryVo(String name) {
		this.name =name;
	}
	
	@Override
	public String toString() {
		
		CategoryDao c = new CategoryDao();
		
		System.out.println("======================카테고리리스트=======================");
	      List<CategoryVo> list = c.getList();
	      for (CategoryVo vo : list) {
	         System.out.print(vo.getName() + " ");
	      }
	      
	      System.out.println("");
	      System.out.println("");
		
		return null;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
