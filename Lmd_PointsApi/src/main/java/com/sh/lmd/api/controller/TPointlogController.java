package com.sh.lmd.api.controller;

import com.sh.common.vo.R;
import com.sh.lmd.api.service.TPointlogService;
import com.sh.lmd.entity.TPointlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TPointlogController {
    @Autowired
    private TPointlogService pointlogService;

    @GetMapping("user/pointlog.do")
    R queryPointlogByUserId(@RequestParam("userId") int userId, @RequestParam("way") int way){
        return pointlogService.queryPointlogByUserId(userId, way);
    }

    @PostMapping("user/pointlog/save.do")
    R savePointlog(@RequestBody TPointlog tPointlog){
        return pointlogService.savePointlog(tPointlog);
    }

    @GetMapping("user/pointlog/queryMonth.do")
    R queryMonthLog(@RequestParam("userId") int userId){
        return pointlogService.queryMonthLog(userId);
    }

}
