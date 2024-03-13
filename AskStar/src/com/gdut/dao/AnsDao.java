package com.gdut.dao;

import com.gdut.pojo.Ans;

import java.util.List;

//这层用来对数据增删改查
public interface AnsDao {
     public int addAns(Ans ans);
     public List<Ans> findAllAns();

}
