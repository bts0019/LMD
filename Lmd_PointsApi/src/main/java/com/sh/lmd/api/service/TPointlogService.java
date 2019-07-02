package com.sh.lmd.api.service;

import com.sh.common.vo.R;
import com.sh.lmd.entity.TPointlog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "UserPointsProvider")
public interface TPointlogService {

    @GetMapping("user/pointlog.do")
    R queryPointlogByUserId(@RequestParam("userId") int userId, @RequestParam("way") int way);

    @PostMapping("user/pointlog/save.do")
    R savePointlog(@RequestBody TPointlog tPointlog);

    @GetMapping("user/pointlog/queryMonth.do")
    R queryMonthLog(@RequestParam("userId") int userId);
}
