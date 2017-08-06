package com.company.ssm.service;

import com.company.ssm.dao.BlogDao;
import com.company.ssm.dao.UsersDao;
import com.company.ssm.model.Blog;
import com.company.ssm.model.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by ZZ on 2017/6/27.
 */
@Service
public class BlogService {
    Logger log = Logger.getLogger(BlogService.class);

    @Resource
    private BlogDao blogDao;

    public List<Blog> getAllBlog() {
        List<Blog> result = blogDao.getAllBlog();
        if (result == null) {
            log.error("blog list is empty");
        }
        return result;
    }

    /**
     * 返回的值是key-value的形式，具体格式
     * title->标题一
     * user_name->****
     *
     * @param tid
     * @return
     */
    public Map<String, Object> getBlogDetailByTid(int tid) {
        log.info("get blog detail by tid: " + tid);
        Map<String, Object> result = blogDao.getBlogDetail(tid);
        if (result == null) {
            log.error("no blog with tid: " + tid);
        }
        return result;
    }

    public List<Blog> getLabelBlog(String labelName) {
        List<Blog> result = blogDao.getLabelBlog(labelName);
        int size = result.size();
        if (result == null) {
            log.info("there is no blog that label is " + labelName);
        } else {
            log.info("there have " + size + " blog that label is " + labelName);
        }
        return result;
    }

    /**
     * Insert blog into table blog
     *
     * @param userId
     * @param title
     * @param author
     * @param type
     * @param label
     * @param decoration
     * @param content
     * @param createTime
     * @param alterTime
     * @return
     */
    public int addBlog(int userId,
                       String title,
                       String author,
                       int type,
                       String label,
                       String decoration,
                       String content,
                       LocalDateTime createTime,
                       LocalDateTime alterTime) {
        int tid = blogDao.addBlog(userId, title, author, type, label, decoration, content, createTime, alterTime);
        if (tid == 0) {
            log.error("Insert blog fail.");
            return 0;
        }
        return tid;
    }

    /**
     * 更新博客
     * @param tid blogId
     * @param title 标题
     * @param label 标签
     * @param content 内容
     * @param decoration 描述
     * @param alertTime 修改时间
     */
    public void updateBlog(int tid,
                           String title,
                           String label,
                           String content,
                           String decoration,
                           LocalDateTime alertTime) {
        blogDao.updateBlog(tid,title, label, content,decoration, alertTime);
    }
}
