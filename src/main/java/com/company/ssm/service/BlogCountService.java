package com.company.ssm.service;

import com.company.ssm.dao.BlogCountDao;
import com.company.ssm.dao.UsersDao;
import com.company.ssm.model.BlogCount;
import com.company.ssm.model.Users;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ZZ on 2017/6/27.
 */
@Service
public class BlogCountService {
    Logger log = Logger.getLogger(BlogCountService.class);

    @Resource
    private BlogCountDao blogCountDao;

    public List<BlogCount> getAllUsers() {
        return blogCountDao.getAllBlogCount();
    }
}
