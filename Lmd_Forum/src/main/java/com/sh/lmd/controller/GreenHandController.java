package com.sh.lmd.controller;


import com.sh.lmd.entity.Greenhand;
import com.sh.lmd.entity.Takeaway;
import com.sh.lmd.service.GreenhandService;
import com.sh.lmd.service.TakeAwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GreenHandController {

    @Autowired(required = false)
    private GreenhandService greenhandService;

    @GetMapping("greenhandlist.do")
    public List<Greenhand> findAll(){

        return greenhandService.findAll();
    }

    @PostMapping("insertSelective.do")
    public int insertSelective(Greenhand greenhand){

       return greenhandService.insertSelective(greenhand);
    }

}
