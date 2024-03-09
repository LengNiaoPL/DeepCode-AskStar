package com.gdut.dao;

import com.gdut.pojo.Question;

import java.util.List;

public interface QuestionDao {

    public int addQuestion(Question question);

    public List<Question> findAllQuestion();


}
