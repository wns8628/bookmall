package com.douzone.bookmall.vo;

import java.util.List;

import com.douzone.bookmall.dao.CartDao;

public class CartVo{
	
	public CartVo() {}
	

	public CartVo(int customer_no, int book_no, int count) {		
		this.customer_no = customer_no;
		this.book_no = book_no;
		this.count = count;		
	}
	
	private int no; 
	private int customer_no; 
	private int book_no;
	private int count;
	
	//조인위해
	private String title;
	private String name;
	private int price;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	@Override
	public String toString() {
		
		CartDao c = new CartDao();
		
		System.out.println("======================카트리스트=======================");
	      List<CartVo> list = c.getCartList();
	      for (CartVo vo : list) {
	         System.out.println("제목:"+ vo.getTitle() + 
	        		  		  ", 수량:" + vo.getCount() + 
	        		  		  ", 가격:" + vo.getPrice() + 
	        		  		  ", 고객:" + vo.getName());
	      }

		     System.out.println("");
				
		return null;
	}	
}
