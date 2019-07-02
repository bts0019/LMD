package com.sh.lmd.server.user.point.dao;

import com.sh.lmd.entity.TPointlog;
import com.sh.lmd.entity.TQuestion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TQuestionMapper {
    // 从题库随机得到一个问题返回
    TQuestion queryQuestion(int id);
    // 查询答题是否正确
    TQuestion selectAnswer(String answer);
    // 最后一天是否答题
    TPointlog selectByUserIdLast(int userId);
    //近 7天的答题数据 近30天的签到数据
    List<TPointlog> selectByUserIdDays(@Param("userId") int userId, @Param("days") int days);

}
