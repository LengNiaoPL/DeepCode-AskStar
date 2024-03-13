package com.gdut.dao.impl;
import com.gdut.dao.BaseDao;
import com.gdut.dao.UserDao;
import com.gdut.pojo.AskUser;
import com.gdut.util.MD5Util;

import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public int addUser(AskUser askUser) {
        int row=0;//影响了多少条数据
         String sql="INSERT INTO users VALUES(DEFAULT,?,?)";
         row=baseUpdate(sql,askUser.getUsername(), MD5Util.encrypt(askUser.getPasswd()) );
        return row;
    }

    @Override
    public List<AskUser> findAllUser() {
        String sql="select uid,username,passwd from users";
        List<AskUser> userList=baseQuery(AskUser.class,sql);
        return userList ;
    }


}
