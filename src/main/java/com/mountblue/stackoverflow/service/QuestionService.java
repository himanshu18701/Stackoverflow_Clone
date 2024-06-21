package com.mountblue.stackoverflow.service;


import com.mountblue.stackoverflow.Entity.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findAllQuestion();
    Question findQuestionById(int id);
    Question saveQuestion(Question question);
    Question updateQuestion(Question question);
    void deleteQuestionById(int id);
}
