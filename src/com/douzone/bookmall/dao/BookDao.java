package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.douzone.bookmall.vo.BookVo;

public class BookDao {
		
	
	public List<BookVo> getbookList(){
		
	      List<BookVo> list = new ArrayList<BookVo>();
	      Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;

	      try {
	         conn = getConnection();

	         // 3. Staement 객체를 생성
	         stmt = conn.createStatement();

	         // 4. SQL문 실행
	         String sql = "	select a.title, b.name, a.price\r\n" + 
	         		"	 from book a, category b\r\n" + 
	         		"	where b.no = a.category_no";
	         rs = stmt.executeQuery(sql);

	         // 5. 결과 가져오기
	         while(rs.next()) {
	        	 String title = rs.getString(1);
	        	 String category = rs.getString(2);
	        	 int price = rs.getInt(3);
	        	 
	        	 BookVo vo= new BookVo();	        	 
	        	 vo.setTitle(title);
	        	 vo.setCategory(category);
	        	 vo.setPrice(price);
	        	 
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
	
	public List<BookVo> getList(){
		
	      List<BookVo> list = new ArrayList<BookVo>();
	      Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;

	      try {
	         conn = getConnection();

	         // 3. Staement 객체를 생성
	         stmt = conn.createStatement();

	         // 4. SQL문 실행
	         String sql = "select * from book";
	         rs = stmt.executeQuery(sql);

	         // 5. 결과 가져오기
	         while(rs.next()) {
	        	 int no = rs.getInt(1);
	        	 String title = rs.getString(2);
	        	 int price = rs.getInt(3);
	        	 int customer_no = rs.getInt(4);
	        	 
	        	 BookVo vo= new BookVo();
	        	 vo.setNo(no);
	        	 vo.setTitle(title);
	        	 vo.setPrice(price);;
	        	 vo.setCategory_no(customer_no);
	        	 
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
	
	
	public boolean insert(BookVo bookvo) {
	     Connection conn = null;
	      PreparedStatement pstmt = null;
	      boolean result = false;
	      try {

	         conn = getConnection();				  //제목 가격 카테고리번호
	         String sql = "insert into book values(null, ?, ?, ?)";
	         pstmt = conn.prepareStatement(sql);

	         pstmt.setString(1, bookvo.getTitle());
	         pstmt.setLong(2, bookvo.getPrice());
	         pstmt.setLong(3, bookvo.getCategory_no());

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
