package com.hdw.mockUi.controller.user;

import com.hdw.mockUi.entity.UserInfo;
import com.hdw.mockUi.service.IUserInterFace;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private IUserInterFace iuser;

    @RequestMapping("/sayHello")
    @ResponseBody
    String home(){
        Integer userid = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userSession");
        return "user,session,hello";
    }

    @RequestMapping("/getUser")
    @ResponseBody
    List<UserInfo> getUser(){
        return iuser.getAllUser();
    }


}
