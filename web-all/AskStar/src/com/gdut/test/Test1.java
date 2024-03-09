package com.gdut.test;

import com.gdut.dao.BaseDao;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test1 {
   private static BaseDao baseDao;

   @BeforeClass
   public static void  initBaseDao(){
       baseDao=new BaseDao();
   }

   @Test
   public void test1(){
      String sql="select users.username from users";
     String s = baseDao.baseQueryObject(String.class,sql);
      System.out.println(s);
   }
}
