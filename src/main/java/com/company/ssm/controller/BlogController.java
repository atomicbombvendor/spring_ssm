package com.company.ssm.controller;

import com.company.ssm.Enums.OperationEnum;
import com.company.ssm.model.Blog;
import com.company.ssm.service.BlogService;
import com.company.ssm.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.inject.Named;
import java.util.List;

/**
 * Created by ZZ on 2017/6/27.
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
    Logger log = Logger.getLogger(BlogController.class);

    @Resource
    private BlogService blogService;

    @RequestMapping("/showBlog")
    public String showBlog(Model model){
        log.info(OperationEnum.SHOW_ALL_USERS.getMessage());
        List<Blog> BlogList = blogService.getAllBlog();
        model.addAttribute("blogList",BlogList);
        return "front/showBlog";
    }
}
