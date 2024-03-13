package com.gdut.dao.impl;

import com.gdut.dao.AnsDao;
import com.gdut.dao.BaseDao;
import com.gdut.pojo.Ans;

import java.util.List;

public class AnsDaoImpl extends BaseDao implements AnsDao {


    @Override
    public int addAns(Ans ans) {
        int row=0;
        String sql="insert into ans values(DEFAULT,?,?)";
        row=baseUpdate(sql,ans.getAnses(),ans.getWhatans());
        return row;
    }

    @Override
    public List<Ans> findAllAns() {
        String sql="select aid,anses,whatans from ans";
        List<Ans> ansList=baseQuery(Ans.class,sql);
        return ansList;
    }


}
