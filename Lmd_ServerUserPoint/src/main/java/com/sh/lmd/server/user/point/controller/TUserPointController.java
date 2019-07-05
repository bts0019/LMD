package com.sh.lmd.server.user.point.controller;

import com.sh.common.vo.R;
import com.sh.lmd.server.user.point.service.TUserPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TUserPointController {
    @Autowired
    private TUserPointService pointService;

    @GetMapping("user/point.do")
    public R allPoints(int userId){
        return pointService.queryPointById(userId);
    }
}
