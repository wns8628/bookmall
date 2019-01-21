package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.CustomerDao;
import com.douzone.bookmall.vo.CustomerVo;

public class CustomerDaoTest {

   public static void main(String[] args) {
      insertTest("둘리", "1111-1234", "Dooly@naver.com", "Busan", "1234");
      insertTest("또치", "2222-1234", "Ddochi@naver.com", "Seoul", "4321");
      getListTest();
   }

   public static void insertTest(String name, String phone, String email, String shipping, String password) {
      CustomerVo vo = new CustomerVo();
      vo.setName(name);
      vo.setPhone(phone);
      vo.setEmail(email);
      vo.setShipping(shipping);
      vo.setPassword(password);
      new CustomerDao().insert(vo);
   }

   public static void getListTest() {
      List<CustomerVo> list = new CustomerDao().getList();
      for (CustomerVo vo : list) {
         System.out.println(vo);
      }
   }
}