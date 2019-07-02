package com.sh.lmd.mentity;

public class Members {
    private Integer id;

    private String name;

    private Integer birthgift;

    private Integer redits;

    private Integer flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getBirthgift() {
        return birthgift;
    }

    public void setBirthgift(Integer birthgift) {
        this.birthgift = birthgift;
    }

    public Integer getRedits() {
        return redits;
    }

    public void setRedits(Integer redits) {
        this.redits = redits;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}