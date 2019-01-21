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
import com.douzone.bookmall.vo.CustomerVo;

public class CustomerDao {


   // select
   public List<CustomerVo> getList() {
      List<CustomerVo> list = new ArrayList<CustomerVo>();
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;

      try {
         conn = getConnection();

         stmt = conn.createStatement();

         String sql = "select no, name, phone, email, shipping, password from customer";
         rs = stmt.executeQuery(sql);

         while (rs.next()) {
            Long no = rs.getLong(1);
            String name = rs.getString(2);
            String phone = rs.getString(3);
            String email = rs.getString(4);
            String shipping = rs.getString(5);
            String password = rs.getString(6);

            CustomerVo vo = new CustomerVo();
            vo.setNo(no);
            vo.setName(name);
            vo.setPhone(phone);
            vo.setEmail(email);
            vo.setShipping(shipping);
            vo.setPassword(password);

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

   // insert
   public boolean insert(CustomerVo customervo) {
      Connection conn = null;
      PreparedStatement pstmt = null;
      boolean result = false;
      try {
         conn = getConnection();
         String sql = "insert into customer values (null, ?, ?, ?, ?, ?)";
         pstmt = conn.prepareStatement(sql);

         pstmt.setString(1, customervo.getName());
         pstmt.setString(2, customervo.getPhone());
         pstmt.setString(3, customervo.getEmail());
         pstmt.setString(4, customervo.getShipping());
         pstmt.setString(5, customervo.getPassword());
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