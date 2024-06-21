package com.mountblue.stackoverflow.service;

import com.mountblue.stackoverflow.Entity.Question;
import com.mountblue.stackoverflow.repository.QuestionRepository;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
    @Override
    public List<Question> findAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public Question findQuestionById(int id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        int id=question.getId();
        Question existingQuestion = questionRepository.findById(id).orElse(null);
        existingQuestion.setContent(question.getContent());
        existingQuestion.setTitle(question.getTitle());
        return questionRepository.save(existingQuestion);
    }

    @Override
    public void deleteQuestionById(int id) {
        questionRepository.deleteById(id);
    }
}
