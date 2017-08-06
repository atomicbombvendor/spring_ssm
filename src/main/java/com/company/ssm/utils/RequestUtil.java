package com.company.ssm.utils;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ZZ on 2017/8/6.
 */
public class RequestUtil {
    private static Logger log = Logger.getLogger(RequestUtil.class);

    /**
     * Check Request is synchronous Or asynchronous
     * @param request
     */
    public static void checkSynchronous(HttpServletRequest request){
        String qq = request.getHeader("x-requested-with");//为 null，则为传统同步请求，为 XMLHttpRequest，则为 Ajax 异步请求。
        if(qq.equals("XMLHttpRequest")){
            log.info("Request is Ajax asynchronous");
        }else{
            log.info("Request is synchronous");
        }
    }
}
