package com.mountblue.stackoverflow.controller;


import com.mountblue.stackoverflow.Entity.Answer;
import com.mountblue.stackoverflow.Entity.Question;
import com.mountblue.stackoverflow.service.AnswerService;
import com.mountblue.stackoverflow.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/answers")
public class AnswerController {

    private final AnswerService answerService;
    private final QuestionService questionService;

    @Autowired
    public AnswerController(AnswerService answerService, QuestionService questionService) {
        this.answerService = answerService;
        this.questionService = questionService;
    }

    @PostMapping("/save-answers")
    public String addAnswer(@RequestParam("questionId") int questionId, @ModelAttribute("answer") Answer answer) {
        answerService.saveAnswer(questionId, answer);
        return "redirect:/questions/" + questionId;
    }
}
