package com.company.ssm.dao;

import com.company.ssm.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.inject.Named;
import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */
//Spring的注解形式：@Repository、@Service、@Controller，它们分别对应存储层Bean，业务层Bean，和展示层Bean。
@Repository
public interface UserDao {

    User selectUserById(@Param("userId") Long userId);

    User selectUserByPhoneOrEmail(@Param("emailOrPhone") String emailOrPhone, @Param("state") Short state);

    List<User> selectAllUser();

    /**
     * user_name 对应于mapper中的sql参数
     * @param user_name userName
     * @return User
     */
    User selectUserByName(@Param("user_name") String user_name);

    User selectUserByEmail(@Param("user_email") String user_email);

    int addNewUser(@Param("user_name") String user_name, @Param("user_email") String user_email,
                   @Param("user_pwd") String user_pwd);
}
