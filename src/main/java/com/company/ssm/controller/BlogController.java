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
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by ZZ on 2017/6/27.
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
    Logger log = Logger.getLogger(BlogController.class);
    private static int pageSize=5;

    @Resource
    private BlogService blogService;

    @RequestMapping("/showBlog")
    public String showBlog(Model model){
        log.info(OperationEnum.SHOW_ALL_BLOG.getMessage());
        List<Blog> blogList = blogService.getAllBlog();
        Iterator it = blogList.iterator();
        while(it.hasNext()){
            Blog b = (Blog)it.next();
        }
        int value = blogList.size()%pageSize;
        int pageNum = value==0?value:value+1;//count of pages
        log.info("BlogList size is "+blogList.size());
        model.addAttribute("blogList",blogList);
        model.addAttribute("pageNum",pageNum);
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

    @RequestMapping("/labelBlog")
    public String showLabelBlog(@RequestParam String labelName, Model model) throws UnsupportedEncodingException {
        byte[] b = labelName.getBytes("ISO-8859-1");
        String value = new String(b, "UTF-8");
        System.out.println("search label: "+value);
        log.info("search label: "+value);
        log.info("中文测试");
        List<Map<String, Object>> resultList= blogService.getLabelBlog(value);
        model.addAttribute("blogList",resultList);
        model.addAttribute("Label","labelName");
        return "front/blogTags";
    }
}
