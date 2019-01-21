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
import com.douzone.bookmall.vo.RequestVo;

public class RequestDao {

	public List<RequestVo> orderList(){
		
	      List<RequestVo> list = new ArrayList<RequestVo>();
	      Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;

	      try {
	         conn = getConnection();

	         // 3. Staement 객체를 생성
	         stmt = conn.createStatement();

	         // 4. SQL문 실행
	         String sql = "select a.no as \"주문번호\", b.name , b.email, c.총주문가격, b.shipping" + 
	         		"  from request a, customer b , (select c.no, sum(b.count * a.price) as '총주문가격'" + 
	         		"								  from book a, cart b, customer c" + 
	         		"								 where a.no = b.book_no" + 
	         		"								   and c.no = b.customer_no" + 
	         		"							  group by c.no) c" + 
	         		" where a.customer_no = b.no" + 
	         		"  and b.no = c.no";
	         rs = stmt.executeQuery(sql);

	         // 5. 결과 가져오기
	         while(rs.next()) {
	        	 int no = rs.getInt(1);
	        	 String name = rs.getString(2);
	        	 String email = rs.getString(3);
	        	 int sumprice = rs.getInt(4);
	        	 String shipping = rs.getString(5);
	        	 
	        	 RequestVo vo= new RequestVo();
	        	 vo.setNo(no);
	        	 vo.setName(name);
	        	 vo.setEmail(email);
	        	 vo.setSumprice(sumprice);
	        	 vo.setShipping(shipping);
	        	 
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
	
	
	public List<RequestVo> getList(){
		
	      List<RequestVo> list = new ArrayList<RequestVo>();
	      Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;

	      try {
	         conn = getConnection();

	         // 3. Staement 객체를 생성
	         stmt = conn.createStatement();

	         // 4. SQL문 실행
	         String sql = "select no, customer_no from request"; 
	         rs = stmt.executeQuery(sql);

	         // 5. 결과 가져오기
	         while(rs.next()) {
	        	 int no = rs.getInt(1);
	        	 int customer_no = rs.getInt(2);

	        	 RequestVo vo= new RequestVo();
	        	 vo.setNo(no);
	        	 vo.setCustomer_no(customer_no);
	        	 
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
	
	public boolean insert(RequestVo requestvo) {
	     Connection conn = null;
	      PreparedStatement pstmt = null;
	      boolean result = false;
	      try {

	         conn = getConnection();				     
	         String sql = "insert into request values(null, ?)";
	         pstmt = conn.prepareStatement(sql);

	         pstmt.setInt(1, requestvo.getCustomer_no());

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
