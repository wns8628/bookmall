package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.dao.CategoryDao;
import com.douzone.bookmall.vo.BookVo;
import com.douzone.bookmall.vo.CategoryVo;

public class CategoryDaoTest{
	public static void main(String args[]) {
//		insertTest("요리");
		getlistTest();
	}
	
	public static void insertTest(String name) {
		
		CategoryVo vo = new CategoryVo();
		vo.setName(name);
		
		new CategoryDao().insert(vo);
	}
	
	public static void getlistTest() {
		List<CategoryVo> list = new CategoryDao().getList();
		for(CategoryVo vo:list) {
			System.out.println(vo);
		}
	}
}
