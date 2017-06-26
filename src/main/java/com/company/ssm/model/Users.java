package com.company.ssm.model;

import javax.inject.Named;
import java.sql.Timestamp;

/**
 * Created by ZZ on 2017/6/26.
 */
@Named("users")
public class Users {
    private long userId;
    private String userName;
    private String userPsd;
    private Timestamp regTime;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPsd() {
        return userPsd;
    }

    public void setUserPsd(String userPsd) {
        this.userPsd = userPsd;
    }

    public Timestamp getRegTime() {
        return regTime;
    }

    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }
}
