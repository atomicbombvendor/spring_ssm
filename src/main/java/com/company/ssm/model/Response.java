package com.company.ssm.model;

import javax.inject.Named;
import java.sql.Timestamp;

/**
 * Created by ZZ on 2017/6/26.
 */
@Named("response")
public class Response {//response comment
    private long postId;
    private long userId;
    private int tid;
    private String content;
    private long respondId;
    private Timestamp createTime;

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getRespondId() {
        return respondId;
    }

    public void setRespondId(long respondId) {
        this.respondId = respondId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
