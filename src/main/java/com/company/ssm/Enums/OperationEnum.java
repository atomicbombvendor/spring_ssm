package com.company.ssm.Enums;

public enum OperationEnum {
    ADD_NEW_USER(1001,"add a new user:%s"),
    UPDATE_USER(1002,"update user:%s"),
    DELETE_USER(1003,"delete userId:%d"),

    SHOW_ALL_USERS(1004,"show all Users"),
    SHOW_ALL_BLOG(1005,"show all blogs");

    private String message;
    private int key;

    OperationEnum(int key, String message){
        this.key = key;
        this.message = message;
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