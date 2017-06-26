package com.company.ssm.model;

import javax.inject.Named;
import java.sql.Timestamp;

/**
 * Created by ZZ on 2017/6/26.
 */
@Named("blog")
public class Blog {
    private long tid;
    private long userId;
    private String title;
    private String author;
    private int type;//7001 原创 7002 转载
    private String loadURL;
    private String label;
    private String decoration;
    private String content;
    private Timestamp createTime;
    private Timestamp updateTime;
    private int state;

    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLoadURL() {
        return loadURL;
    }

    public void setLoadURL(String loadURL) {
        this.loadURL = loadURL;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDecoration() {
        return decoration;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
