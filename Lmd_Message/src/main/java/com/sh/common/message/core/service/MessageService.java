package com.sh.common.message.core.service;


import com.sh.common.message.core.entity.Message;
import com.sh.common.vo.R;

/**
 *@Author feri
 *@Date Created in 2019/6/13 10:47
 */
public interface MessageService {
    R sendMsg(Message message, String ip);
    R page(int page, int count);
    R checkCode(String phone, int code);
    R sendMessage(Message message, String ip);

}
