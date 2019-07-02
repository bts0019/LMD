package com.sh.lmd.controller;


import com.sh.lmd.mentity.MemberInfo;
import com.sh.lmd.mentity.Members;
import com.sh.lmd.service.MemberCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberCardController {

    @Autowired(required = false)
    private MemberCardService memberCard;

    @GetMapping("memberlist.do")
    public List<Members> findAll(){

       return memberCard.findAll();
    }

    @GetMapping("memberinfolist.do")
    public List<MemberInfo> findAllInfo(){

        return memberCard.findAllInfo();
    }


}
