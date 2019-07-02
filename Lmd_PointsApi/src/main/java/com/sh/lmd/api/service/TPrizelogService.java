package com.sh.lmd.api.service;

import com.sh.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "UserPointsProvider")
public interface TPrizelogService {

    @GetMapping("user/prizelog/queryByUserId.do")
    R queryPrizelogByUserId(@RequestParam("userId") int userId);

    @GetMapping("user/prizelog/queryAll.do")
    R queryAllPrizelog();
}
