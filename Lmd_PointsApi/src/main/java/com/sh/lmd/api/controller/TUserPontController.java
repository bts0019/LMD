package com.sh.lmd.api.controller;

import com.sh.common.vo.R;
import com.sh.lmd.api.service.TUserPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TUserPontController {
    @Autowired
    private TUserPointService pointService;

    @GetMapping("user/point.do")
    public R allPoints(@RequestParam("userId") int userId){
        return pointService.allPoints(userId);
    }
}
