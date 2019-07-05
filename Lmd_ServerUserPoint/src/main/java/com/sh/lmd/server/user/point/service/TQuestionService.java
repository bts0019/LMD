package com.sh.lmd.server.user.point.service;

import com.sh.common.vo.R;

public interface TQuestionService {
    R queryQuestion();
    R answerQuestion(String token, String answer);
    R checkAnswer(String answer);


}
