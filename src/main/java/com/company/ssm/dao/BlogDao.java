package com.company.ssm.dao;

import com.company.ssm.model.Blog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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

    List<Blog> selectBlogByTid(@Param("tid") int tid);

    Map<String, Object> getBlogDetail(@Param("tid") int tid);

    List<Blog> getLabelBlog(@Param("label") String label);

    int addBlog(@Param("user_id") int userId,
                @Param("title") String title,
                @Param("author") String author,
                @Param("type") int type,
                @Param("label") String label,
                @Param("decoration") String decoration,
                @Param("content") String content,
                @Param("createTime") LocalDateTime createTime,
                @Param("alter_time") LocalDateTime alterTime);

    int updateBlog(
            @Param("tid") int tid,
            @Param("title") String title,
            @Param("label") String label,
            @Param("content") String content,
            @Param("decoration") String decoration,
            @Param("alter_time") LocalDateTime alertTime);
}
