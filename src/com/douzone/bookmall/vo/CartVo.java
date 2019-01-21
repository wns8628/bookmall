package com.douzone.bookmall.vo;

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
		return "cartVo [no=" + no + ", customer_no=" + customer_no + ", book_no=" + book_no + ", count=" + count + "]";
	}	
}
