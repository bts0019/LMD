package com.sh.lmd.server.user.point.controller;

import com.sh.common.vo.R;
import com.sh.lmd.server.user.point.service.TPrizelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TPrizelogController {
    @Autowired
    private TPrizelogService prizelogService;

    @GetMapping("user/prizelog/queryByUserId.do")
    R queryPrizelogByUserId(int userId){
        return prizelogService.queryPrizelogByUserId(userId);
    }

    @GetMapping("user/prizelog/queryAll.do")
    R queryAllPrizelog(){
        return prizelogService.queryAllPrizelog();
    }
}
