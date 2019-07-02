package com.sh.lmd.api.service;

import com.sh.common.vo.R;
import com.sh.lmd.entity.TUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *@Author feri
 *@Date Created in 2019/6/12 17:18
 */
@FeignClient(name = "UserProvider")
public interface UserService {
    //新增
    @PostMapping("user/save.do")
    R save(@RequestBody TUser user);

    @GetMapping("user/all.do")
    R all();


}
