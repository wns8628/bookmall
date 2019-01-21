package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.vo.BookVo;

public class BookDaoTest {
	public static void main(String args[]) {
		
//		insertTest("나루토2",3000, 1);
		 getlistTest();
		 
	}
	
	public static void insertTest(String title, int price, int category_no) {
		
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setPrice(price);
		vo.setCategory_no(category_no);
		
		new BookDao().insert(vo);
	}
	
	public static void getlistTest() {
		List<BookVo> list = new BookDao().getList();
		for(BookVo vo:list) {
			System.out.println(vo);
		}
	}
	
}
