package com.douzone.bookmall.vo;

import java.util.List;

import com.douzone.bookmall.dao.CustomerDao;

public class CustomerVo {
   private long no;
   private String name;
   private String phone;
   private String email;
   private String shipping;
   private String password;
   
   public CustomerVo(){}
   
   public CustomerVo(String name, 
		   			 String phone,
		   			 String email,
		   			 String shipping,
		   			 String password) {
	   
	   this.name = name;
	   this.phone = phone;
	   this.email = email;
	   this.shipping =shipping;
	   this.password = password;	   
   }
   
public long getNo() {
	return no;
}
public void setNo(long no) {
	this.no = no;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getShipping() {
	return shipping;
}
public void setShipping(String shipping) {
	this.shipping = shipping;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	
	CustomerDao c = new CustomerDao();
	
	System.out.println("======================회원리스트=======================");
      List<CustomerVo> list = c.getList();
      for (CustomerVo vo : list) {
         System.out.println("이름:" + vo.getName() +
        		 		    ", 번호:" + vo.getPhone() + 
        		 		     ", 이메일 :" + vo.getEmail() + 
        		 		     ", 패스워드:" + vo.getPassword());
      }
     System.out.println("");
     
	return null;
}
 
   
}