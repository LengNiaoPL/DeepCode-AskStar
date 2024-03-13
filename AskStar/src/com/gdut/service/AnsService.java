package com.gdut.service;

import com.gdut.pojo.Ans;

import java.util.List;

public interface AnsService {
    int addAns(Ans ans);

    List<Ans> findAns(int whatans);

}
