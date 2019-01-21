package com.douzone.bookmall.main;

import java.util.List;

import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.dao.CartDao;
import com.douzone.bookmall.dao.CategoryDao;
import com.douzone.bookmall.dao.CustomerDao;
import com.douzone.bookmall.dao.DataAllDeleteDao;
import com.douzone.bookmall.dao.Order_bookDao;
import com.douzone.bookmall.dao.RequestDao;
import com.douzone.bookmall.vo.BookVo;
import com.douzone.bookmall.vo.CartVo;
import com.douzone.bookmall.vo.CategoryVo;
import com.douzone.bookmall.vo.CustomerVo;
import com.douzone.bookmall.vo.Order_bookVo;
import com.douzone.bookmall.vo.RequestVo;

public class BookMallMain {

	public static void main(String[] args) {
		
		// 데이터 넣기
		insertData();
		
		// 1. 회원리스트 
		showCustomer();
		// 2. 카테고리 리스트 – 3개
		showCategotyList();
		// 3. 상품리스트 – 3개
		showBookList();
		// 4. 카트 리스트 – 2개
		showCartList();
		// 5. 주문 리스트 – 1개
		showOrderList();
		// 6. 주문 도서 리스트 – 2개
		showOrderBookList();
	
		//데이터 다 지우기
		deleteAllData();
		
	}

//-----------------------------------------------------------------------------------------------------------------------------------
	

	//데이터삽입
	private static void insertData() {
		CustomerDao   customerdao    = new CustomerDao();
		CategoryDao   categorydao    = new CategoryDao();
		BookDao 	  bookdao   	 = new BookDao();
		CartDao	   	  cartdao	     = new CartDao();
		RequestDao    requestdao 	 = new RequestDao();
		Order_bookDao orderbookdao   = new Order_bookDao();
	

		customerdao.insert(new CustomerVo("김세준","010-4250-7675","wns8628@naver.com","부산","1111"));
		customerdao.insert(new CustomerVo("김택주","010-2222-2222","xorwn@naver.com","부산","2222"));
		customerdao.insert(new CustomerVo("최기석","010-3333-3333","rltjr@naver.com","부산","3333"));
		customerdao.insert(new CustomerVo("김상욱","010-4444-4444","tkddnr@naver.com","부산","4444"));
		customerdao.insert(new CustomerVo("심지영","010-5555-5555","wldud@naver.com","부산","5555"));
		

		categorydao.insert(new CategoryVo("액션")); //장르1
		categorydao.insert(new CategoryVo("판타지")); 
		categorydao.insert(new CategoryVo("멜로"));
		categorydao.insert(new CategoryVo("무협"));
		categorydao.insert(new CategoryVo("SF"));
		
		bookdao.insert(new BookVo("나루토",2500,1)); //책이름, 가격, 장르
		bookdao.insert(new BookVo("원피스",3000,2));
		bookdao.insert(new BookVo("블리치",3000,1));
		bookdao.insert(new BookVo("이누야사",2000,3));
		bookdao.insert(new BookVo("헌터x헌터",4000,4));
		
		cartdao.insert(new CartVo(1,1,3));  //고객번호, 도서번호 , 수량 
		cartdao.insert(new CartVo(5,4,10));
		cartdao.insert(new CartVo(1,5,5));
		cartdao.insert(new CartVo(2,2,3));
		cartdao.insert(new CartVo(2,2,3));
		
		requestdao.insert(new RequestVo(1)); //고객번호
		requestdao.insert(new RequestVo(2));  
		//1번고객과 2번고객만 주문한다.
		
		//1~5번의 책의 판매현황을 보기위해 1~5번책을다넣어준다.
		orderbookdao.insert(new Order_bookVo(1)); //책번호 
		orderbookdao.insert(new Order_bookVo(2));
		orderbookdao.insert(new Order_bookVo(3));
		orderbookdao.insert(new Order_bookVo(4));
		orderbookdao.insert(new Order_bookVo(5));
	}
		
	//다지우기
	private static void deleteAllData() {
		new DataAllDeleteDao().deleteAll();
	}
	
	private static void showCustomer() {
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
	}

	private static void showCategotyList() {
		CategoryDao c = new CategoryDao();
		
		System.out.println("======================카테고리리스트=======================");
	      List<CategoryVo> list = c.getList();
	      for (CategoryVo vo : list) {
	         System.out.print(vo.getName() + " ");
	      }
	      
	      System.out.println("");
	      System.out.println("");
	}
	
	private static void showBookList() {
		
		BookDao b = new BookDao();
		
		System.out.println("======================상품리스트=======================");
	      List<BookVo> list = b.getbookList();
	      for (BookVo vo : list) {
	         System.out.println("제목:"+ vo.getTitle() +
	        		 		  ", 장르:" + vo.getCategory() +
	        		  		  ", 가격" + vo.getPrice());
	      }

		     System.out.println("");
	}
	

	private static void showCartList() {
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
	}
	

	private static void showOrderList() {
		
		RequestDao r = new RequestDao();
		
		System.out.println("======================주문리스트=======================");
	      List<RequestVo> list = r.orderList();
	      for (RequestVo vo : list) {
	         System.out.println("주문번호:"+ vo.getNo() + 
	        		  		  ", 이름:" + vo.getName() + 
	        		  		  ", 이메일:" + vo.getEmail() + 
	        		  		  ", 총주문가격:" + vo.getSumprice() +
	        		  		  ", 배송지:" + vo.getShipping());
	      }

		     System.out.println("");
	}

	private static void showOrderBookList() {
		
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
	}
}
