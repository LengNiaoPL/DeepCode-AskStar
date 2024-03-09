package com.gdut.dao;

import com.gdut.pojo.AskUser;

import java.util.List;

public interface UserDao {
    public int addUser(AskUser askUser);

    public List<AskUser> findAllUser();

}
