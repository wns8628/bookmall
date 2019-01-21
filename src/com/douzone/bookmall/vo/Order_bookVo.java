package com.douzone.bookmall.vo;

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
		return "order_bookVo [no=" + no + ", book_no=" + book_no + "]";
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
