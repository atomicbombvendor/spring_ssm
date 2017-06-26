package com.company.ssm.model;

import javax.inject.Named;

/**
 * Created by ZZ on 2017/6/26.
 */
@Named("blog_count")
public class BlogCount {
    private long tid;
    private long readCount;
    private long upVote;

    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }

    public long getReadCount() {
        return readCount;
    }

    public void setReadCount(long readCount) {
        this.readCount = readCount;
    }

    public long getUpVote() {
        return upVote;
    }

    public void setUpVote(long upVote) {
        this.upVote = upVote;
    }
}
