package com.usian.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.util.Date;

public class Student {
    @Id
    private Integer sid;
    private Integer xuehao;
    private String sname;
    private  Integer sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sdata;
    //

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getXuehao() {
        return xuehao;
    }

    public void setXuehao(Integer xuehao) {
        this.xuehao = xuehao;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getSdata() {
        return sdata;
    }

    public void setSdata(Date sdata) {
        this.sdata = sdata;
    }
}
