package com.douzone.bookmall.vo;

public class RequestVo {
	
	public RequestVo() {}
	
	public RequestVo(int customer_no) {
		this.customer_no = customer_no;
	}
	
	private int no;
	private int customer_no;
	
	//조인위해
	private String name;
	private String email;
	private int sumprice;
	private String shipping;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSumprice() {
		return sumprice;
	}
	public void setSumprice(int sumprice) {
		this.sumprice = sumprice;
	}
	public String getShipping() {
		return shipping;
	}
	public void setShipping(String shipping) {
		this.shipping = shipping;
	}
	@Override
	public String toString() {
		return "requestVo [no=" + no + ", customer_no=" + customer_no + "]";
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
	
	
	
}
