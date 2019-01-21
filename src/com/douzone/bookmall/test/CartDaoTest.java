package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.CartDao;
import com.douzone.bookmall.vo.CartVo;

public class CartDaoTest {
	public static void main(String args[]) {
		insertTest(2,1,5);
		getlistTest();		
	}
	
	public static void insertTest(int customer_no, int book_no, int count) {
		
		CartVo vo = new CartVo();
		vo.setCustomer_no(customer_no);
		vo.setBook_no(book_no);
		vo.setCount(count);
		
		new CartDao().insert(vo);
	}
	
	public static void getlistTest() {
		List<CartVo> list = new CartDao().getList();
		for(CartVo vo:list) {
			System.out.println(vo);
		}
	}
}
