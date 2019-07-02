package com.sh.lmd.api.controller;

import com.sh.common.vo.R;
import com.sh.lmd.api.service.TPrizelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TPrizelogController {
    @Autowired(required = false)
    private TPrizelogService prizelogService;

    @GetMapping("user/prizelog/queryByUserId.do")
    R queryPrizelogByUserId(@RequestParam("userId") int userId){
        return prizelogService.queryPrizelogByUserId(userId);
    }

    @GetMapping("user/prizelog/queryAll.do")
    R queryAllPrizelog(){
        return prizelogService.queryAllPrizelog();
    }
}
