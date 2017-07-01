package com.company.ssm.dao;

import com.company.ssm.model.Blog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by ZZ on 2017/6/26.
 */
@Repository
public interface BlogDao {
    List<Blog> getAllBlog();

    List<Blog> selectAllBlog();

    List<Blog> selectBlogByTid(@Param("tid") int tid);

    Map<String, Object> getBlogDetail(@Param("tid") int tid);
}
