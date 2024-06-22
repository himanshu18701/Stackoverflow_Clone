package com.mountblue.stackoverflow.controller;

import com.mountblue.stackoverflow.Entity.Answer;
import com.mountblue.stackoverflow.Entity.Question;
import com.mountblue.stackoverflow.Entity.User;
import com.mountblue.stackoverflow.service.AnswerService;
import com.mountblue.stackoverflow.service.QuestionService;
import com.mountblue.stackoverflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/questions")
public class QuestionController {
    QuestionService questionService;
    UserService userService;
    private final AnswerService answerService;

    @Autowired
    public QuestionController(QuestionService questionService, UserService userService, AnswerService answerService) {
        this.questionService = questionService;
        this.userService = userService;
        this.answerService = answerService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<Question> questions = questionService.findAllQuestion();
        model.addAttribute("questions", questions);
        return "home";
    }

    @GetMapping("/create")
    public String showQuestionForm(Model model) {
        model.addAttribute("question", new Question());
        return "ask-question";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("question") Question question) {
        User user = userService.findById(1);
        question.setUser(user);
        questionService.saveQuestion(question);
        return "redirect:/questions/create";
    }

    @GetMapping("/{id}")
    public String showQuestion(@PathVariable("id") int id, Model model) {
        Question question = questionService.findQuestionById(id);
        List<Answer> answers = answerService.findAllAnswers(id);
        model.addAttribute("question", question);
        model.addAttribute("answers", answers);
        model.addAttribute("answer", new Answer());
        return "question-page";
    }
}