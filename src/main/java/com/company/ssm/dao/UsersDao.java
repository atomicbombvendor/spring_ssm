package com.company.ssm.dao;

import com.company.ssm.model.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by ZZ on 2017/6/26.
 */
@Repository
public interface UsersDao {
    List<Users> getAllUsers();

    Map<String, Object> getUser(@Param("userName") String userName, @Param("userPsd") String userPsd);

    Users getUserById(@Param("uId") int uId);
}
