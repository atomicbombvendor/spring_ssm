package com.company.ssm.model;

import javax.inject.Named;

/**
 * Created by ZZ on 2017/5/4.
 */
@Named("students")
public class Student {
    private int sid;
    private String name;
    private String sex;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
