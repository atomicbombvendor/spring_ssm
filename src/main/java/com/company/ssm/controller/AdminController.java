package com.company.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.company.ssm.Enums.OperationEnum;
import com.company.ssm.model.Blog;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by eli9 on 7/27/2017.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    Logger log = Logger.getLogger(BlogController.class);

    /**
     * ajax请求不需要返回页面，只需要得到response中的数据即可，所以方法签名为void即可
     */
    @RequestMapping(value="test", method= RequestMethod.POST)
    public void showBlog(HttpServletRequest request, HttpServletResponse response){
        log.info("admin test");
        String jsonResult = getJSONString(request);
        renderData(response, jsonResult);
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
