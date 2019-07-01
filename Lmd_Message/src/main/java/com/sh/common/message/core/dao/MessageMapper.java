package com.sh.common.message.core.dao;


import com.sh.common.message.core.entity.Message;

import java.util.List;

public interface MessageMapper {

    int insert(Message record);

    List<Message> selectAll();
}