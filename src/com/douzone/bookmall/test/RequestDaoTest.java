package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.RequestDao;
import com.douzone.bookmall.vo.RequestVo;

public class RequestDaoTest {
	public static void main(String args[]) {
//		insertTest(2);
		getlistTest();
	}

	
	
	public static void insertTest(int customer_no) {		
		RequestVo vo = new RequestVo();
		vo.setCustomer_no(customer_no);
		
		new RequestDao().insert(vo);
	}
	
	public static void getlistTest() {
		List<RequestVo> list = new RequestDao().getList();
		for(RequestVo vo:list) {
			System.out.println(vo);
		}
	}
}
