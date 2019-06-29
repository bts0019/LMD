package com.sh.lmd.entity;

import lombok.Data;

import java.util.Date;
@Data
public class TCoupon {
    private Integer cid;

    private Integer uid;

    private Integer status;

    private Date createtime;

    private Date endtime;

    private Integer minmoney;

    private Integer money;

    private String password;

    private Integer getType;

}