package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.CartVo;
import com.douzone.bookmall.vo.CategoryVo;

public class CartDao {

	public List<CartVo> getCartList(){
		
	      List<CartVo> list = new ArrayList<CartVo>();
	      Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;

	      try {
	         conn = getConnection();

	         // 3. Staement 객체를 생성
	         stmt = conn.createStatement();

	         // 4. SQL문 실행
	         String sql = "SELECT \r\n" + 
	         		"    c.title, a.합계, b.합계, d.name\r\n" + 
	         		"FROM\r\n" + 
	         		"    (SELECT \r\n" + 
	         		"        a.no, SUM(b.count) '합계'\r\n" + 
	         		"    FROM\r\n" + 
	         		"        book a, cart b, customer c\r\n" + 
	         		"    WHERE\r\n" + 
	         		"        a.no = b.book_no\r\n" + 
	         		"	AND \r\n" + 
	         		"		b.customer_no = c.no\r\n" + 
	         		"    GROUP BY a.no) a,\r\n" + 
	         		"    (SELECT \r\n" + 
	         		"        a.no, SUM((a.price * b.count)) '합계'\r\n" + 
	         		"    FROM\r\n" + 
	         		"        book a, cart b, customer c\r\n" + 
	         		"    WHERE\r\n" + 
	         		"        a.no = b.book_no\r\n" + 
	         		"            AND b.customer_no = c.no\r\n" + 
	         		"    GROUP BY a.no) b,\r\n" + 
	         		"    book c,\r\n" + 
	         		"    customer d,\r\n" + 
	         		"    cart e\r\n" + 
	         		"WHERE\r\n" + 
	         		"    a.no = b.no AND b.no = c.no\r\n" + 
	         		"        AND c.no = e.book_no\r\n" + 
	         		"        AND d.no = e.customer_no"; 
	         
	         rs = stmt.executeQuery(sql);

	         // 5. 결과 가져오기
	         while(rs.next()) {
	        	 String title = rs.getString(1);
	        	 int count = rs.getInt(2);
	        	 int price = rs.getInt(3);
	        	 String name = rs.getString(4);
	        	 
	        	 CartVo vo= new CartVo();
	        	 vo.setTitle(title);
	        	 vo.setCount(count);
	        	 vo.setPrice(price);
	        	 vo.setName(name);
	        	 
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
	
	
	public List<CartVo> getList(){
		
	      List<CartVo> list = new ArrayList<CartVo>();
	      Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;

	      try {
	         conn = getConnection();

	         // 3. Staement 객체를 생성
	         stmt = conn.createStatement();

	         // 4. SQL문 실행
	         String sql = "select no, customer_no, book_no, count from cart"; 
	         rs = stmt.executeQuery(sql);

	         // 5. 결과 가져오기
	         while(rs.next()) {
	        	 int no = rs.getInt(1);
	        	 int customer_no = rs.getInt(2);
	        	 int book_no = rs.getInt(3);
	        	 int count = rs.getInt(4);
	        	 
	        	 CartVo vo= new CartVo();
	        	 vo.setNo(no);
	        	 vo.setCustomer_no(customer_no);;
	        	 vo.setBook_no(book_no);
	        	 vo.setCount(count);
	        	 
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
	
	
	
	public boolean insert(CartVo cartvo) {
	     Connection conn = null;
	      PreparedStatement pstmt = null;
	      boolean result = false;
	      try {

	         conn = getConnection();		     //사용자번호, 북번호
	         String sql = "insert into cart values(null, ?, ?, ?)";
	         pstmt = conn.prepareStatement(sql);

	         pstmt.setInt(1, cartvo.getCustomer_no());
	         pstmt.setInt(2, cartvo.getBook_no());
	         pstmt.setInt(3, cartvo.getCount());

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
