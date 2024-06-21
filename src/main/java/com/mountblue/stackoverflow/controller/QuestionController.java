package com.mountblue.stackoverflow.controller;

import com.mountblue.stackoverflow.Entity.Question;
import com.mountblue.stackoverflow.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/questions")
public class QuestionController {
    QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/create")
    public String home(Model model) {
        model.addAttribute("question", new Question());
        return "ask-question";
    }

    @PostMapping("/create")
    public void create(@ModelAttribute("question") Question question) {
        questionService.saveQuestion(question);
    }
}
