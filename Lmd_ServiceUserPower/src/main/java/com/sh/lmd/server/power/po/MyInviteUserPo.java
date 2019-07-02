package com.sh.lmd.server.power.po;

import lombok.Data;

import java.util.Date;

/**
 * 此类是显示用户邀请人员的信息
 */
@Data
public class MyInviteUserPo {

    private String userName;

    private Date createTime;

    private Integer status;

    private Integer reward;
}
