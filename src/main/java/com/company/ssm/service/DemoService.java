package com.company.ssm.service;

import com.company.ssm.dao.UsersDao;
import com.company.ssm.model.Users;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ZZ on 2017/6/27.
 */
@Service
public class DemoService {
    Logger log = Logger.getLogger(DemoService.class);

    @Resource
    private UsersDao usersDao;

    public List<Users> getAllUsers() {
        return usersDao.getAllUsers();
    }
}
