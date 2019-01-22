package com.douzone.bookmall.main;

import java.util.ArrayList;
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
		
		//출력
		show(); 
		
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
	
	//출력
	private static void show() {

	    ArrayList<Object> list = new ArrayList<Object>();	
	    list.add(new CustomerVo());
	    list.add(new CategoryVo());
	    list.add(new BookVo());
	    list.add(new CartVo());
	    list.add(new RequestVo());
	    list.add(new Order_bookVo());
		
	    for(int i = 0 ; i< list.size(); i++) {
	    	 list.get(i).toString();	
	    }
		
	}
}
