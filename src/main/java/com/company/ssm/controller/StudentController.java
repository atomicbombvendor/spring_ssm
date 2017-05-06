package com.company.ssm.controller;

import com.company.ssm.model.Student;
import com.company.ssm.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by ZZ on 2017/5/4.
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    private Logger log = Logger.getLogger(StudentController.class);
    @Resource
    private StudentService studentService;

    @RequestMapping("/showStudent")
    public String showStudent(HttpServletRequest request, Model model){
        List<Student> list = studentService.getAllStudent();
        model.addAttribute("studentList",list);
        return "showStudent";//return to page name
    }

    @RequestMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("id") int id, Model model){
        System.out.println("Id: "+id);
        List<Student> list = studentService.getAllStudent();
        model.addAttribute("studentList",list);
        return "showStudent";
    }

}
