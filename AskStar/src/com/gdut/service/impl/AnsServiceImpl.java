package com.gdut.service.impl;

import com.gdut.dao.AnsDao;
import com.gdut.dao.impl.AnsDaoImpl;
import com.gdut.pojo.Ans;
import com.gdut.service.AnsService;

import java.util.ArrayList;
import java.util.List;

public class AnsServiceImpl implements AnsService {
    AnsDao ansDao=new AnsDaoImpl();
    @Override
    public int addAns(Ans ans) {
        return ansDao.addAns(ans);
    }

    @Override
    public List<Ans> findAns(int whatans) {
        List<Ans> ansList=new ArrayList<>();
        List<Ans> list=ansDao.findAllAns();
        for (Ans ans:list){
            if (ans.getWhatans()==whatans){
                ansList.add(ans);
            }
        }
        return ansList;
    }
}
