package com.company.ssm.service;

import com.company.ssm.dao.BlogDao;
import com.company.ssm.dao.UsersDao;
import com.company.ssm.model.Blog;
import com.company.ssm.model.Users;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
}
