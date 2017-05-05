package com.company.ssm.service.impl;

import com.company.ssm.dao.StudentDao;
import com.company.ssm.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ZZ on 2017/5/4.
 */
@Service
public class StudentService {
    @Resource
    private StudentDao studentDao;

    public List<Student> getAllStudent(){
        return studentDao.getAllStudent();
    }

    public List<Student> getStudentByName(String name){
        return studentDao.getStudentByName(name);
    }

    public Student getStudentById(int id){
        return studentDao.getStudentById(id);
    }
}
