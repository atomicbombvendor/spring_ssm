package com.company.ssm.dao;

import com.company.ssm.model.BlogCount;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZZ on 2017/6/26.
 */
@Repository
public interface BlogCountDao {
    List<BlogCount> getAllBlogCount();
}
