package com.sh.lmd.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TUser {

    private Integer userId;
    private String userName;
    private String password;
    private String realName;
    private Integer adressId;
    private String phone;
    private String email;
    private Integer status;
    private Integer city;
    private Date createTime;
    private Integer vip;
    private Integer integral; //积分
    private String img;
    private String idCard;
}