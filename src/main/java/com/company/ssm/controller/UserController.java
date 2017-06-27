package com.company.ssm.controller;

import com.company.ssm.Enums.OperationEnum;
import com.company.ssm.model.User;
import com.company.ssm.service.UserService;
import com.company.ssm.utils.PasswordUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    public String showUser(Model model){
        log.info(OperationEnum.SHOW_ALL_USERS.getMessage());
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList",userList);
        return "jsp/showUser";
    }

    //@RequestParam获取前台的参数,()中的name要与表单中的控件名一样。或者 @RequestParam String ${parameterName}
    @RequestMapping("/newUser")
    public String addNewUser(@RequestParam String userName, @RequestParam String email, @RequestParam String pwd, Model model){
        log.info(String.format(OperationEnum.ADD_NEW_USER.getMessage(),String.format("UName:%s email:%s pwd:%s", userName, email, pwd)));
        String password = PasswordUtil.generate(pwd);
        int result = userService.addNewUser(userName,email,password);
        log.info("add new user result:"+result);
        if(result>0) {
            return showUser(model);
        }else{
            return showUser(model);
        }
    }
}
