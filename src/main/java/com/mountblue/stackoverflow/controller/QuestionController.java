package com.mountblue.stackoverflow.controller;

import com.mountblue.stackoverflow.Entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "ask-questions";
    }

    @PostMapping("/create")
    public void create(@RequestParam Question question) {
        questionService.saveQuestion(question);
    }
}
