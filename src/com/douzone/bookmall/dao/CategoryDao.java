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
import com.douzone.bookmall.vo.CategoryVo;

public class CategoryDao {
	
	public List<CategoryVo> getList(){
		
	      List<CategoryVo> list = new ArrayList<CategoryVo>();
	      Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;

	      try {
	         conn = getConnection();

	         // 3. Staement 객체를 생성
	         stmt = conn.createStatement();

	         // 4. SQL문 실행
	         String sql = "select no, name from category"; 
	         rs = stmt.executeQuery(sql);

	         // 5. 결과 가져오기
	         while(rs.next()) {
	        	 int no = rs.getInt(1);
	        	 String name = rs.getString(2);

	        	 CategoryVo vo= new CategoryVo();
	        	 vo.setNo(no);
	        	 vo.setName(name);;
	        	 
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
	
	
	public boolean insert(CategoryVo categoryvo) {
	     Connection conn = null;
	      PreparedStatement pstmt = null;
	      boolean result = false;
	      try {

	         conn = getConnection();				       //카테고리이름
	         String sql = "insert into category values(null, ?)";
	         pstmt = conn.prepareStatement(sql);

	         pstmt.setString(1, categoryvo.getName());

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
