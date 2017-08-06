package com.company.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.company.ssm.Enums.OperationEnum;
import com.company.ssm.model.Users;
import com.company.ssm.service.BlogService;
import com.company.ssm.service.UsersService;
import com.company.ssm.utils.PinYinUtil;
import com.company.ssm.utils.RequestUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.json.Json;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by eli9 on 7/27/2017.
 */
@Controller
@RequestMapping("/admin")
@SessionAttributes("userId")
public class AdminController {
    Logger log = Logger.getLogger(BlogController.class);

    @Resource
    private BlogService blogService;

    @Resource
    private UsersService usersService;

    /**
     * ajax请求不需要返回页面，只需要得到response中的数据即可，所以方法签名为void即可
     */
    @RequestMapping(value = "test", method = RequestMethod.POST)
    public void showBlog(HttpServletRequest request, HttpServletResponse response) {
        log.info("admin test");
        String jsonResult = getJSONString(request);
        renderData(response, jsonResult);
    }

    /**
     * user login
     */
    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response, String userName, String password) {
        RequestUtil.checkSynchronous(request);
        log.info("user: " + userName + " try to login and pwd is " + password);
        Map<String, Object> user = usersService.getUser(userName, password);
        if (user == null) {
            return;
        }
        //设置session属性
        Long uId = (Long)user.get("user_id");
        request.getSession().setAttribute("uId", uId);
        request.getSession().setAttribute("userName", userName);

        Map<String, Object> result = new HashMap<>();
        result.put("uId", uId);

        renderData(response, JSON.toJSONString(result));
    }

    /**
     * show all blog
     * @param request
     * @param response
     * @param uId
     */
    @ResponseBody
    @RequestMapping(value = "show", method = RequestMethod.POST)
    public void show(HttpServletRequest request, HttpServletResponse response, String uId) {
        log.info("current uId is " + uId);
        log.info(OperationEnum.SHOW_ALL_BLOG.getMessage());
        List blogList = blogService.getAllBlog();
        //使用fastJson生成JSONArray
        JSONArray json = new JSONArray(blogList);
        try {
            response.setCharacterEncoding("UTF-8");
            String result = json.toString();
            response.getWriter().write(result);
        } catch (IOException e) {
            log.error("json IO Exception", e);
        }
    }

    /**
     * Show all blog by label name
     * @param request
     * @param response
     * @param label
     */
    @ResponseBody
    @RequestMapping(value = "label", method = RequestMethod.POST)
    public void showLabel(HttpServletRequest request, HttpServletResponse response, String label) {
        try {
            byte[] b = label.getBytes("UTF-8");
            String transCodingValue = new String(b, "UTF-8");
            log.info("back end search label: " + PinYinUtil.getPinYin(transCodingValue));
            List resultList = blogService.getLabelBlog(label);
            //使用fastJson生成JSONArray
            JSONArray json = new JSONArray(resultList);
            response.setCharacterEncoding("UTF-8");
            String result = json.toString();
            response.getWriter().write(result);
        } catch (UnsupportedEncodingException e) {
            log.error("不支持的字符类型：" + label, e);
        } catch (IOException e) {
            log.error("写入Json错误", e);
        }
    }

    /**
     * Get blog by blog id
     * @param request  request
     * @param response response
     * @param tid      blog id
     */
    @ResponseBody
    @RequestMapping(value = "blog", method = RequestMethod.POST)
    public void getBlog(HttpServletRequest request, HttpServletResponse response, int tid) {
        try {
            Map<String, Object> blog = blogService.getBlogDetailByTid(tid);
            JSONObject json = new JSONObject(blog);
            response.setCharacterEncoding("UTF-8");
            String result = json.toString();
            response.getWriter().write(result);
        } catch (IOException e) {
            log.error("json error when trans map to json", e);
        }
    }

    /**
     * 如果前台的blogId为空，则表示新建博客。不为空，则表示修改博客
     * @param request request
     * @param response response
     * @param blogId blogId
     * @param title title
     * @param desc desc
     * @param content content
     * @param label label
     */
    @ResponseBody
    @RequestMapping(value="save", method = RequestMethod.POST)
    public void saveBlog(HttpServletRequest request, HttpServletResponse response,
                         String blogId,//前台传出的参数
                         String title,//标题
                         String desc,
                         String content,
                         String label){//标签 要求用空格隔开
        int uid = (Integer)request.getSession().getAttribute("uId");
        String userName = (String)request.getSession().getAttribute("userName");
        String labelS = label.replace(" ", ",");

        LocalDateTime createTime = LocalDateTime.now();
        LocalDateTime alterTime = LocalDateTime.now();

        if(content.isEmpty()){return;}//不能让数据库中的博客的内容为空
        if(blogId.isEmpty()) {//表示为新建博客
            //TODO Type类型的参数传入
            int type = 1001;//表示原创

            int tid = blogService.addBlog(uid, title, userName, type, labelS, desc, content, createTime, alterTime);
            if (tid == 0) {
                log.error("BlogService insert blog failed");
            }
            outPut(response, (new Integer(tid)).toString());
        }else{
            blogService.updateBlog(Integer.parseInt(blogId), title, label, content, desc, alterTime);
            outPut(response, "success");
        }
    }
    /**
     * mock some json result
     */
    private String getJSONString(HttpServletRequest request) {
        //故意构造一个数组，使返回的数据为json数组，数据更复杂些
        List<Map<String, Object>> datas = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>(10);
        //可以获得ajax请求中的参数
        map1.put("a", request.getParameter("content"));
        map1.put("b", "b");
        map1.put("c", "c");
        datas.add(map1);

        Map<String, Object> map2 = new HashMap<>(10);
        map2.put("a", "11");
        map2.put("b", "22");
        map2.put("c", "33");
        datas.add(map2);

        String jsonResult = JSON.toJSONString(datas);
        return jsonResult;
    }

    /**
     * 通过PrintWriter将响应数据写入response，ajax可以接受到这个数据
     **/
    private void renderData(HttpServletResponse response, String data) {
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            pw.print(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != pw) {
                pw.flush();
                pw.close();
            }
        }
    }

    /**
     * 使用PrintWrite输出resutl
     * @param response
     * @param result
     */
    private void outPut(HttpServletResponse response, String result){
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            pw.write(JSON.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            pw.flush();pw.close();
        }
    }
}
