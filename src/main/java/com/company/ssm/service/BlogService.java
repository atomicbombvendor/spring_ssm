package com.company.ssm.service;

import com.company.ssm.dao.BlogDao;
import com.company.ssm.dao.UsersDao;
import com.company.ssm.model.Blog;
import com.company.ssm.model.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        System.out.println("get all blog");
        List<Blog> result = blogDao.getAllBlog();
        if(result == null){
            log.error("blog list is empty");
        }
        return result;
    }

    /**
     * 返回的值是key-value的形式，具体格式
     * title->标题一
     * user_name->****
     * @param tid
     * @return
     */
    public Map<String, Object> getBlogDetailByTid(int tid){
        log.info("get blog detail by tid: "+tid);
        Map<String, Object> result = blogDao.getBlogDetail(tid);
        if(result==null) {
            log.error("no blog with tid: "+ tid);
        }
        return result;
    }
}
