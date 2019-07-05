package com.sh.lmd.entity;

import java.util.Date;

public class TBorrow {
    private Integer bid;

    private String bname;

    private Integer bmoney;

    private Date btime;

    private String bdesc;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    public Integer getBmoney() {
        return bmoney;
    }

    public void setBmoney(Integer bmoney) {
        this.bmoney = bmoney;
    }

    public Date getBtime() {
        return btime;
    }

    public void setBtime(Date btime) {
        this.btime = btime;
    }

    public String getBdesc() {
        return bdesc;
    }

    public void setBdesc(String bdesc) {
        this.bdesc = bdesc == null ? null : bdesc.trim();
    }
}