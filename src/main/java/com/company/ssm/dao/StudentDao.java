package com.company.ssm.dao;

import com.company.ssm.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZZ on 2017/5/4.
 */
@Repository
public interface StudentDao {
    Student getStudentById(@Param("id") int id);

    List<Student> getStudentByName(@Param("name") String name);

    List<Student> getAllStudent();
}
