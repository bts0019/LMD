package com.sh.common.message.core.dao;

import com.sh.common.message.core.entity.MsgReceive;

import java.util.List;


public interface MsgReceiveMapper {

    int insert(MsgReceive record);

    List<MsgReceive> selectAll();
}