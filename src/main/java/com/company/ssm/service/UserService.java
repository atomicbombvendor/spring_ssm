package com.company.ssm.service;

import com.company.ssm.Enums.ServiceOperation;
import com.company.ssm.dao.UserDao;
import com.company.ssm.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
    Logger log = Logger.getLogger(UserService.class);
    
    @Resource
    private UserDao userDao;

    public User getUserById(Long userId) {
        return userDao.selectUserById(userId);
    }

    public User getUserByPhoneOrEmail(String emailOrPhone, Short state) {
        return userDao.selectUserByPhoneOrEmail(emailOrPhone,state);
    }

    public String selectUserByName(String user_name){
        return userDao.selectUserByName(user_name).getUserName();
    }

    public boolean isUserNameExists(String user_name){
        log.info(String.format(ServiceOperation.USER_SERIVCE_SELECTBY.getMessage(),"userName:"+user_name));
        return user_name.equals(userDao.selectUserByName(user_name).getUserName());
    }

    public boolean isEmailExists(String email){
        log.info(String.format(ServiceOperation.USER_SERIVCE_SELECTBY.getMessage()," email:"+email));
        return email.equals(userDao.selectUserByName(email));
    }

    public List<User> getAllUser() {
        return userDao.selectAllUser();
    }

    public int addNewUser(String user_name, String user_email,
                          String md5psd){
        log.info(String.format(ServiceOperation.USER_SERVICE_ADDUSERE.getMessage(),user_name));
        boolean NameIsExists = false;
        boolean EmailIsExists = false;
        NameIsExists = isUserNameExists(user_name);
        EmailIsExists = isEmailExists(user_email);

        if(NameIsExists || EmailIsExists){
            return 0;
        }else{
            return userDao.addNewUser(user_name, user_email, md5psd);
        }
    }
}
