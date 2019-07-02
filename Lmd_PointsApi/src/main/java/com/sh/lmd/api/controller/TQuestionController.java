package com.sh.lmd.api.controller;

import com.sh.common.vo.R;
import com.sh.lmd.api.service.TQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TQuestionController {
    @Autowired
    private TQuestionService questionService;

    @GetMapping("user/question.do")
    R questionEveryday(){
        return questionService.questionEveryday();
    }

    @PostMapping("user/question/checkAnswer.do")
    R checkAnswer(@RequestParam("answer") String answer){
        return questionService.checkAnswer(answer);
    }

    @PostMapping("user/question/answer.do")
    R answerQuestion(@RequestParam("token") String token, @RequestParam("answer") String answer){
        return questionService.answerQuestion(token, answer);
    }
}
