package com.sh.lmd.server.user.point.controller;

import com.sh.common.vo.R;
import com.sh.lmd.entity.TPointlog;
import com.sh.lmd.server.user.point.service.TPointlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TPointlogController {
    @Autowired
    private TPointlogService pointlogService;

    @GetMapping("user/pointlog.do")
    R queryPointlogByUserId(int userId, int way){
        return pointlogService.queryPointlog(userId, way);
    }

    @PostMapping("user/pointlog/save.do")
    R savePointlog(@RequestBody TPointlog tPointlog){
        return pointlogService.savePointlog(tPointlog);
    }

    @GetMapping("user/pointlog/queryMonth.do")
    R queryMonthLog(int userId){
        return pointlogService.queryMonthLog(userId);
    }

}
