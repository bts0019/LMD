package com.sh.lmd.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TPointlog {
    private Integer id;

    private Integer userId;

    private String ptype;

    private Integer points;

    private Date ptime;

    private Integer way;

    private Integer days;

}