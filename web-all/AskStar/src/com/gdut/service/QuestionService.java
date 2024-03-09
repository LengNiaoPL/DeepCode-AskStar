package com.gdut.service;

import com.gdut.pojo.Question;

import java.util.List;

public interface QuestionService {
    int addQuestion(Question question);

    List<Question> findQuestion(String username);

}
