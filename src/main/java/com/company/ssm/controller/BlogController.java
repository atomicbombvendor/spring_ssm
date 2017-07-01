package com.company.ssm.controller;

import com.company.ssm.Enums.OperationEnum;
import com.company.ssm.model.Blog;
import com.company.ssm.service.BlogService;
import com.company.ssm.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        log.info(OperationEnum.SHOW_ALL_BLOG.getMessage());
        List<Blog> BlogList = blogService.getAllBlog();
        log.info("BlogList size is "+BlogList.size());
        model.addAttribute("blogList",BlogList);
        return "front/showBlog";
    }

    @RequestMapping("/showBlogDetail")
    public String showBlogDetail(@RequestParam int tid, Model model){
        log.info("show blog detail");
        Map<String, Object> resultMap = blogService.getBlogDetailByTid(tid);

        Map<String, String> resultTest = new HashMap<>();
        resultMap.put("key1","value1");
        resultMap.put("key2","value2");
        resultMap.put("key3","value3");
        model.addAttribute("resultMap",resultMap);
        model.addAttribute("resultTest",resultTest);
        return "front/blogDetail";
    }
}
