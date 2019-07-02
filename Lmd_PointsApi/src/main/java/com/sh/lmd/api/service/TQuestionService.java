package com.sh.lmd.api.service;

import com.sh.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "UserPointsProvider")
public interface TQuestionService {

    @GetMapping("user/question.do")
    R questionEveryday();

    @PostMapping("user/question/checkAnswer.do")
    R checkAnswer(@RequestParam("answer") String answer);

    @PostMapping("user/question/answer.do")
    R answerQuestion(@RequestParam("token") String token, @RequestParam("answer") String answer);
}
