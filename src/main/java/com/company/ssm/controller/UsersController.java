package com.company.ssm.controller;

import com.company.ssm.Enums.OperationEnum;
import com.company.ssm.model.User;
import com.company.ssm.model.Users;
import com.company.ssm.service.UserService;
import com.company.ssm.service.UsersService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ZZ on 2017/6/27.
 */
@Controller
@RequestMapping("/users")
public class UsersController {
    private Logger log = Logger.getLogger(UsersController.class);
    @Resource
    private UsersService usersService;

    @RequestMapping("/showUsers")
    public String showUser(Model model){
        log.info(OperationEnum.SHOW_ALL_USERS.getMessage());
        List<Users> usersList = usersService.getAllUsers();
        model.addAttribute("usersList",usersList);
        return "jsp/showUser";
    }
}
