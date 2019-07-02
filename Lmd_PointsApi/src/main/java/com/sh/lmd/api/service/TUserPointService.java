package com.sh.lmd.api.service;

import com.sh.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "UserPointsProvider")
public interface TUserPointService {

    @GetMapping("user/point.do")
    R allPoints(@RequestParam("userId") int userId);


}
