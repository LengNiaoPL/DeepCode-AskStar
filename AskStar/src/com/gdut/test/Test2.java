package com.gdut.test;

import com.gdut.dao.impl.AnsDaoImpl;
import com.gdut.pojo.Ans;
import org.junit.Test;

import java.util.List;

public class Test2 {

    @Test
    public void test(){
        AnsDaoImpl ansDao=new AnsDaoImpl();
        int row=ansDao.addAns(new Ans(null,"A",3));
        System.out.println(row);
    }

    @Test
    public void test2(){
        AnsDaoImpl ansDao=new AnsDaoImpl();
        List<Ans> list =ansDao.findAllAns();
        for (Ans ans:list){
            System.out.println(ans.toString());
        }
    }

}
