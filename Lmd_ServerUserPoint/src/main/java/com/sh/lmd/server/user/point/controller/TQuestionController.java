package com.sh.lmd.server.user.point.controller;

import com.sh.common.vo.R;
import com.sh.lmd.server.user.point.service.TQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TQuestionController {
    @Autowired
    private TQuestionService questionService;

    @GetMapping("user/question.do")
    R questionEveryday(){
        return questionService.queryQuestion();
    }

    @PostMapping("user/question/checkAnswer.do")
    R checkAnswer(String answer){
        return questionService.checkAnswer(answer);
    }

    @PostMapping("user/question/answer.do")
    R answerQuestion(String token, String answer){
        return questionService.answerQuestion(token, answer);
    }
}
