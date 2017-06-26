package com.company.ssm.model;

import javax.inject.Named;
import java.sql.Timestamp;

/**
 * Created by ZZ on 2017/6/26.
 */
@Named("response2")
public class Response2 {//second response; comment
   private long postId2;
   private long postId;
   private long userId;
   private String content;
   private Timestamp createTime;

    public long getPostId2() {
        return postId2;
    }

    public void setPostId2(long postId2) {
        this.postId2 = postId2;
    }

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
}
