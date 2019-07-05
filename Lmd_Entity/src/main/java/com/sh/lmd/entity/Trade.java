package com.sh.lmd.entity;

import java.util.Date;

public class Trade {
    private Integer did;

    private String dname;

    private Date dtime;

    private Integer typeflag;

    private Integer dmoney;

    private Integer dbalance;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname == null ? null : dname.trim();
    }

    public Date getDtime() {
        return dtime;
    }

    public void setDtime(Date dtime) {
        this.dtime = dtime;
    }

    public Integer getTypeflag() {
        return typeflag;
    }

    public void setTypeflag(Integer typeflag) {
        this.typeflag = typeflag;
    }

    public Integer getDmoney() {
        return dmoney;
    }

    public void setDmoney(Integer dmoney) {
        this.dmoney = dmoney;
    }

    public Integer getDbalance() {
        return dbalance;
    }

    public void setDbalance(Integer dbalance) {
        this.dbalance = dbalance;
    }
}