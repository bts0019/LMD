package com.sh.lmd.entity;

import java.util.Date;

public class TInterest {
    private Integer interestid;

    private Integer uxuserviceid;

    private Date createtime;

    public Integer getInterestid() {
        return interestid;
    }

    public void setInterestid(Integer interestid) {
        this.interestid = interestid;
    }

    public Integer getUxuserviceid() {
        return uxuserviceid;
    }

    public void setUxuserviceid(Integer uxuserviceid) {
        this.uxuserviceid = uxuserviceid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}