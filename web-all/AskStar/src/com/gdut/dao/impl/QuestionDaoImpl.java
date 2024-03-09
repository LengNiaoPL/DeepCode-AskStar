package com.gdut.dao.impl;

import com.gdut.dao.BaseDao;
import com.gdut.dao.QuestionDao;
import com.gdut.pojo.Question;

import java.util.List;

public class QuestionDaoImpl extends BaseDao implements QuestionDao {
    @Override
    public int addQuestion(Question question) {
        int row=0;
        String sql="insert into question values(DEFAULT,?,?)";
        row=baseUpdate(sql,question.getQuestionchar(),question.getUsername());
        return row;
    }

    @Override
    public List<Question> findAllQuestion() {
        String sql="select qid,questionchar,username from question";
        List<Question> questionList=baseQuery(Question.class,sql);
        return questionList;
    }


}
