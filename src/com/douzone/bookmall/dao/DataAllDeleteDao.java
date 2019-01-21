package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.CustomerVo;

public class DataAllDeleteDao {

	public void deleteAll() {
	      Connection conn = null;
	      Statement stmt = null;

	      try {
	         conn = getConnection();
	         stmt = conn.createStatement();
	         String[] list = null;
	         
	         
	         String sql = "delete from order_book !" +
		         		" delete from request !"  + 
		         		" delete from cart !" + 
		         		" delete from book !" + 
		         		" delete from customer !" + 
		         		" delete from category !" + 
		         		" ALTER TABLE category AUTO_INCREMENT=1 !" + 
		         		" ALTER TABLE book AUTO_INCREMENT=1 !" + 
		         		" ALTER TABLE customer AUTO_INCREMENT=1 !" + 
		         		" ALTER TABLE cart AUTO_INCREMENT=1 !" + 
		         		" ALTER TABLE request AUTO_INCREMENT=1 !" + 
		         		" ALTER TABLE order_book AUTO_INCREMENT=1";

	         list = sql.split("!");
	         
	         for(String li : list) {	 
		         stmt.executeUpdate(li);
	         }
	         

	      } catch (SQLException e) {
	         System.out.println("error: " + e);
	      } finally {
	         try {
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
	   }
	
	   private Connection getConnection() throws SQLException {
		      Connection conn = null;

		      try {
		         Class.forName("com.mysql.jdbc.Driver");

		         String url = "jdbc:mysql://localhost:3306/bookmall";
		         conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		      } catch (ClassNotFoundException e) {
		         System.out.println("드라이버 로딩 실패" + e);
		      }
		      return conn;
		   }
}
