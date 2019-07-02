package com.sh.lmd.entity;

public class TAdress {
    private Integer addressid;

    private String reciname;

    private String phone;

    private String city;

    private String detail;

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public String getReciname() {
        return reciname;
    }

    public void setReciname(String reciname) {
        this.reciname = reciname == null ? null : reciname.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}