package com.sh.lmd.controller;


import com.sh.lmd.entity.Takeaway;
import com.sh.lmd.service.TakeAwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TakeAwayController {

    @Autowired(required = false)
    private TakeAwayService takeAwayService;

    @GetMapping("Takeawaylist.do")
    public List<Takeaway> findAll(){

        return takeAwayService.findAll();
    }

    @GetMapping("selectBytitle.do")
    public List<Takeaway> selectbytitle(String title){

        return takeAwayService.selectBytitle(title);
    }
}
