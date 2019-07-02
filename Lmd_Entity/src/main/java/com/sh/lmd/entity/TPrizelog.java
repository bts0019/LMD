package com.sh.lmd.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class TPrizelog {
    private Integer id;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date ptime;
    private Integer pid;
    private Integer userId;
}
