package com.company.ssm.service;

import com.company.ssm.dao.UsersDao;
import com.company.ssm.model.Users;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by ZZ on 2017/6/27.
 */

/**
 * Table For Blog Users Table
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UsersService {
    Logger log = Logger.getLogger(UsersService.class);

    @Resource
    private UsersDao usersDao;

    public List<Users> getAllUsers() {
        return usersDao.getAllUsers();
    }

    public Map<String, Object> getUser(String userName, String userPsd){
        Map<String, Object> result = usersDao.getUser(userName, userPsd);
        if(result == null){
            log.info("Can't find user: "+userName);
            return null;
        }
        return result;
    }

    public Users getUserById(int uid){
        Users result = usersDao.getUserById(uid);
        if(result == null){
            log.info("Can't find user id: "+uid);
            return null;
        }
        return result;
    }
}
