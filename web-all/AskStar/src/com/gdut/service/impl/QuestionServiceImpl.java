package com.gdut.service.impl;

import com.gdut.dao.QuestionDao;
import com.gdut.dao.impl.QuestionDaoImpl;
import com.gdut.pojo.Question;
import com.gdut.service.QuestionService;

import java.util.ArrayList;
import java.util.List;

public class QuestionServiceImpl implements QuestionService {
    QuestionDao questionDao=new QuestionDaoImpl();

    @Override
    public int addQuestion(Question question) {
        return questionDao.addQuestion(question) ;
    }

    @Override
    public List<Question> findQuestion(String username) {
        List<Question> listAll=questionDao.findAllQuestion();
        List<Question> questionList=new ArrayList<>();
        for (Question question:listAll){
            if (question.getUsername().equals(username)){
                questionList.add(question);
            }
        }
        return questionList;

    }


}
