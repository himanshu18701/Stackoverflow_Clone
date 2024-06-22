package com.mountblue.stackoverflow.service;

import com.mountblue.stackoverflow.Entity.Answer;
import com.mountblue.stackoverflow.Entity.Question;
import com.mountblue.stackoverflow.Entity.User;
import com.mountblue.stackoverflow.repository.AnswerRepository;
import com.mountblue.stackoverflow.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }


    @Override
    public List<Answer> findAllAnswers(int questionId) {
        Question question = questionRepository.findById(questionId).orElse(null);
        return question.getAnswers();
    }

    @Override
    public Answer findAnswerById(int id) {
        return answerRepository.findById(id).orElse(null);
    }

    @Override
    public void saveAnswer(int questionId, Answer answer) {
        Question question = questionRepository.findById(questionId).orElse(null);
        User user = question.getUser();
        answer.setUser(user);
        answer.setQuestion(question);
        answerRepository.save(answer);
    }

    @Override
    public void updateAnswer(Answer answer) {
        Answer oldAnswer = findAnswerById(answer.getId());
        oldAnswer.setContent(answer.getContent());
        answerRepository.save(oldAnswer);
    }

    @Override
    public void deleteAnswer(int id) {
        answerRepository.deleteById(id);
    }
}
