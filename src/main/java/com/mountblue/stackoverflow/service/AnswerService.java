package com.mountblue.stackoverflow.service;

import com.mountblue.stackoverflow.Entity.Answer;

import java.util.List;

public interface AnswerService {
    List<Answer> findAllAnswers(int questionId);
    Answer findAnswerById(int id);
    void saveAnswer(int questionId,Answer answer);
    void updateAnswer(Answer answer);
    void deleteAnswer(int id);
}
