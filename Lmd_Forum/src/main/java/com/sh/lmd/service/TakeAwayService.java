package com.sh.lmd.service;

import com.sh.lmd.entity.Takeaway;

import java.util.List;

public interface TakeAwayService {

    public List<Takeaway> findAll();

    List<Takeaway> selectBytitle(String title);
}
