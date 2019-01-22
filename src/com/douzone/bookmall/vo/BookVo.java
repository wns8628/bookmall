package com.douzone.bookmall.vo;

import java.util.List;

import com.douzone.bookmall.dao.BookDao;

public class BookVo {

	
	private int no; 
	private String title; 
	private int price;
	private int category_no;
	private String category;
	
	public BookVo() {
		
	}
	public BookVo(String title, int price, int category_no) {
		this.title = title;
		this.price =price;
		this.category_no =category_no;
		
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {

		BookDao b = new BookDao();
		
		System.out.println("======================상품리스트=======================");
	      List<BookVo> list = b.getbookList();
	      for (BookVo vo : list) {
	         System.out.println("제목:"+ vo.getTitle() +
	        		 		  ", 장르:" + vo.getCategory() +
	        		  		  ", 가격" + vo.getPrice());
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCategory_no() {
		return category_no;
	}
	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}
	
}
