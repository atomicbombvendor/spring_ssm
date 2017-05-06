package com.company.ssm.Enums;

/**
 * Created by ZZ on 2017/5/6.
 * 定义这些类是没有用的。
 */
public enum ServiceOperation {
    USER_SERVICE_ADDUSERE(2001,"Service: add new user:%s"),
    USER_SERVICE_SELECTALLUSER(2002,"Service: select all user:%s"),
    USER_SERIVCE_SELECTBY(2003,"Serivice: Select by %s:%s");
    private int key;
    private String message;

    //构造函数的参数顺序和定义的枚举顺序一样
    ServiceOperation(int key,String message){
        this.message = message;
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
