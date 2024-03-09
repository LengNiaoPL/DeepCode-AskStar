package com.gdut.service;

import com.gdut.pojo.AskUser;

public interface UserService {
    /**
     * 注册用户的方法
     * @param  user  要注册对象的AskUser类
     * @return 成功返回1,失败返回0
     */
    int regist(AskUser user);

    /**
     * 为了方便代码编写,我们假设用户很少
     * 直接取出所有用户来遍历,看看能不能登入
     * @return boolean
     */
    boolean findAll(String username,String userPwd);
}
