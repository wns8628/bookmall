package com.douzone.bookmall.vo;

import java.util.List;

import com.douzone.bookmall.dao.Order_bookDao;

public class Order_bookVo {
	
	public Order_bookVo() {}
	
	public Order_bookVo(int book_no) {
		this.book_no = book_no;
	}
	
	
	private int no;
	private int book_no;

    //조인위해 
	private String title;
	private int sumCount;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getSumCount() {
		return sumCount;
	}
	public void setSumCount(int sumCount) {
		this.sumCount = sumCount;
	}
	@Override
	public String toString() {
		
		Order_bookDao o = new Order_bookDao();
		
		System.out.println("======================지금까지 주문된 책 리스트=======================");
	      List<Order_bookVo> list = o.orderSellBookList();
	      for (Order_bookVo vo : list) {
	         System.out.println("책 번호:"+ vo.getBook_no() + 
	        		  		  ", 책 이름:" + vo.getTitle() + 
	        		  		  ", 총 판매권수:" + vo.getSumCount()
	        		  		  );
	      }
		System.out.println("");
		
		return null;		
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
}
