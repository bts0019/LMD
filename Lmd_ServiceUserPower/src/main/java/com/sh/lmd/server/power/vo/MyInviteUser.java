package com.sh.lmd.server.power.vo;

import lombok.Data;

import java.util.Date;

/**
 * 此类是显示用户邀请人员的信息 显示信息
 */
@Data
public class MyInviteUser {

    private String userName;

    private Date createTime;

    private Integer status;

    private Double reward;

}
