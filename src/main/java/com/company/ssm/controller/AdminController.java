package com.company.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.company.ssm.Enums.OperationEnum;
import com.company.ssm.model.Blog;
import com.company.ssm.service.BlogService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * ajax请求不需要返回页面，只需要得到response中的数据即可，所以方法签名为void即可
     */
    @RequestMapping(value="test", method= RequestMethod.POST)
    public void showBlog(HttpServletRequest request, HttpServletResponse response){
        log.info("admin test");
        String jsonResult = getJSONString(request);
        renderData(response, jsonResult);
    }

    @ResponseBody
    @RequestMapping(value="login", method=RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response, String userName, String password){
        request.getSession().setAttribute("uId",99);
        String name = userName;
        String pwd = password;
        log.info("user: "+ name+" try to login and pwd is "+ pwd);
        Map<String, Object> result = new HashMap<>();
        result.put("uId",99);
        PrintWriter pw = null;
        //TODO 登录验证
        try {
            if(name.equals("liyan")){
            }else {
                pw = response.getWriter();
                pw.write(JSON.toJSONString(result));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            pw.flush();
            pw.close();
        }
    }

    @ResponseBody
    @RequestMapping(value="show", method=RequestMethod.POST)
    public void show(HttpServletRequest request, HttpServletResponse response, String uId) {
        log.info("current uId is "+uId);
        log.info(OperationEnum.SHOW_ALL_BLOG.getMessage());
        List blogList = blogService.getAllBlog();
        //使用fastJson生成JSONArray
        JSONArray json = new JSONArray(blogList);
        try{
            response.setCharacterEncoding("UTF-8");
            String result = json.toString();
            response.getWriter().write(result);
        }catch (IOException e){
            log.error("json IO Exception",e);
        }
    }

    @ResponseBody
    @RequestMapping(value="label", method=RequestMethod.POST)
    public void showLabel(HttpServletRequest request, HttpServletResponse response, String label){
        try{
            byte[] b = label.getBytes("UTF-8");
            String transCodingValue = new String(b, "UTF-8");
            log.info("back end search label: "+transCodingValue);
            List resultList= blogService.getLabelBlog(label);
            //使用fastJson生成JSONArray
            System.out.println(resultList.get(0));
            JSONArray json = new JSONArray(resultList);
            response.setCharacterEncoding("UTF-8");
            String result = json.toString();
            response.getWriter().write(result);
        }catch (UnsupportedEncodingException e) {
            log.error("不支持的字符类型："+label,e);
        } catch (IOException e) {
            log.error("写入Json错误",e);
        }
    }

    private String getJSONString(HttpServletRequest request){
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
    private void renderData(HttpServletResponse response, String data){
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            pw.print(data);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != pw){
                pw.flush();
                pw.close();
            }
        }
    }
}
