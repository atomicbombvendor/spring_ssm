package com.company.ssm.dao;

import com.company.ssm.model.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZZ on 2017/6/26.
 */
@Repository
public interface UsersDao {
    List<Users> getAllUsers();
}
