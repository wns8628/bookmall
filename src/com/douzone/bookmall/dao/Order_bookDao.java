package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.CategoryVo;
import com.douzone.bookmall.vo.Order_bookVo;

public class Order_bookDao {

	public List<Order_bookVo> orderSellBookList(){
		
	      List<Order_bookVo> list = new ArrayList<Order_bookVo>();
	      Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;

	      try {
	         conn = getConnection();

	         // 3. Staement 객체를 생성
	         stmt = conn.createStatement();

	         // 4. SQL문 실행
	         String sql = "select a.no ,a.title, b.총판매권수 " + 
	         		"  from book a, (select a.no, sum(b.count) as 총판매권수" + 
	         		"				  from book a, cart b, customer c, request d" + 
	         		"				 where a.no = b.book_no" + 
	         		"				   and c.no = b.customer_no" + 
	         		"				   and c.no= d.customer_no" + 
	         		"			  group by a.no) b" + 
	         		" where a.no = b.no"; 
	         rs = stmt.executeQuery(sql);

	         // 5. 결과 가져오기
	         while(rs.next()) {
	        	 int book_no = rs.getInt(1);
	        	 String title = rs.getString(2);
	        	 int sumCount = rs.getInt(3);
	        	 
	        	 Order_bookVo vo= new Order_bookVo();
	        	 vo.setBook_no(book_no);
	        	 vo.setTitle(title);
	        	 vo.setSumCount(sumCount);
	       
	        	 list.add(vo);
	         }
	         
	      } catch (SQLException e) {
	         System.out.println("error: " + e);
	      } finally {
	         try {
	            if (rs != null) {
	               rs.close();
	            }
	            if (stmt != null) {
	               stmt.close();
	            }
	            if (conn != null) {
	               conn.close();
	            }
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }     
	      return list;
	 }
	
	public List<Order_bookVo> getList(){
		
	      List<Order_bookVo> list = new ArrayList<Order_bookVo>();
	      Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;

	      try {
	         conn = getConnection();

	         // 3. Staement 객체를 생성
	         stmt = conn.createStatement();

	         // 4. SQL문 실행
	         String sql = "select no,book_no from order_book"; 
	         rs = stmt.executeQuery(sql);

	         // 5. 결과 가져오기
	         while(rs.next()) {
	        	 int no = rs.getInt(1);
	        	 int book_no = rs.getInt(2);

	        	 Order_bookVo vo= new Order_bookVo();
	        	 vo.setNo(no);
	        	 vo.setBook_no(book_no);
	        	 
	        	 list.add(vo);
	         }
	         
	      } catch (SQLException e) {
	         System.out.println("error: " + e);
	      } finally {
	         try {
	            if (rs != null) {
	               rs.close();
	            }
	            if (stmt != null) {
	               stmt.close();
	            }
	            if (conn != null) {
	               conn.close();
	            }
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }     
	      return list;
	 }
	
	
	
	
	public boolean insert(Order_bookVo order_bookvo) {
	     Connection conn = null;
	      PreparedStatement pstmt = null;
	      boolean result = false;
	      try {

	         conn = getConnection();				       //카테고리이름
	         String sql = "insert into order_book values(null, ?)";
	         pstmt = conn.prepareStatement(sql);

	         pstmt.setInt(1, order_bookvo.getBook_no());

	         int count = pstmt.executeUpdate();

	         result = count == 1;
	      }

	      catch (SQLException e) {
	         System.out.println("error: " + e);
	      } finally {
	         try {
	            if (pstmt != null) {
	               pstmt.close();
	            }
	            if (conn != null) {
	               conn.close();
	            }
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      return result; 
	}
	
	
	// 커넥트 
	   private Connection getConnection() throws SQLException {
			      Connection conn = null;
			      try {
			         Class.forName("com.mysql.jdbc.Driver"); // 패키지 이름

			         String url = "jdbc:mysql://localhost:3306/bookmall"; // DB 종류마다 url이 다르다
			         conn = DriverManager.getConnection(url, "bookmall", "bookmall"); // interface
			      } catch (ClassNotFoundException e) {
			         System.out.println("드라이버 로딩 실패" + e);
			      }
			      return conn;
	   }
}
