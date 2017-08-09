package com.company.ssm.dao;

import com.company.ssm.model.Blog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by ZZ on 2017/6/26.
 */
@Repository
public interface BlogDao {
    List<Blog> getAllBlog();

    List<Blog> selectAllBlog();

    Blog selectBlogByTid(@Param("tid") int tid); //blog Id

    Map<String, Object> getBlogDetail(@Param("tid") int tid);//blog Id

    List<Blog> getBlogByUserId(@Param("uid") Long uId);// user id

    List<Blog> getLabelBlog(@Param("label") String label);

    int addBlog(@Param("user_id") Long userId,
                @Param("title") String title,
                @Param("author") String author,
                @Param("type") Integer type,
                @Param("label") String label,
                @Param("decoration") String decoration,
                @Param("content") String content,
                @Param("createTime") Timestamp createTime,
                @Param("alter_time") Timestamp alterTime);

    int updateBlog(
            @Param("tid") Long tid,
            @Param("title") String title,
            @Param("label") String label,
            @Param("content") String content,
            @Param("decoration") String decoration,
            @Param("alter_time") Timestamp alertTime);
}
