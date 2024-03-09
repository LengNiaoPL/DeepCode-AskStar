package com.gdut.service.impl;

import com.gdut.dao.UserDao;
import com.gdut.dao.impl.UserDaoImpl;
import com.gdut.pojo.AskUser;
import com.gdut.service.UserService;
import com.gdut.util.MD5Util;

import java.util.List;

public class UserServiceImpl implements UserService {
    protected UserDao userDao=new UserDaoImpl();
    @Override
    //注册
    public int regist(AskUser user) {
        return userDao.addUser(user);
    }


    //登入
    @Override
    public boolean findAll(String username,String userPwd) {
        boolean tof=false;
        List<AskUser> list =userDao.findAllUser();
        for (AskUser askUser:list){
            if (askUser.getUsername().equals(username) && askUser.getPasswd().equals(MD5Util.encrypt(userPwd) ) )
              tof=true;
        }
        return tof;
    }

}
