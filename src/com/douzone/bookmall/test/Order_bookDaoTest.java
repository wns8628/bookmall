package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.CategoryDao;
import com.douzone.bookmall.dao.Order_bookDao;
import com.douzone.bookmall.vo.CategoryVo;
import com.douzone.bookmall.vo.Order_bookVo;

public class Order_bookDaoTest {
	public static void main(String args[]) {
//		insertTest(2);
		getlistTest();
	}
	
	
	public static void insertTest(int book_no) {
		
		Order_bookVo vo = new Order_bookVo();
		vo.setBook_no(book_no);;
		
		new Order_bookDao().insert(vo);
	}
	
	public static void getlistTest() {
		List<Order_bookVo> list = new Order_bookDao().getList();
		for(Order_bookVo vo:list) {
			System.out.println(vo);
		}
	}
}
