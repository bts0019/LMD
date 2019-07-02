package com.sh.lmd.controller;


import com.sh.lmd.dao.CardcenterMapper;
import com.sh.lmd.mentity.Cardcenter;
import com.sh.lmd.mentity.MemberInfo;
import com.sh.lmd.service.CardCentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardCenterController {

    @Autowired
    private CardCentService cardCentService;

    @GetMapping("memberinfolist.do")
    public Cardcenter findById(@RequestParam("id")int id){

        return cardCentService.selectByPrimaryKey(id);

    }
}
