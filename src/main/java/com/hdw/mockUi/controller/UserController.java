package com.hdw.mockUi.controller;

import com.hdw.mockUi.entity.UserInfo;
import com.hdw.mockUi.service.IUserInterFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/test")
public class UserController {
    @Autowired
    private IUserInterFace iuser;

    @RequestMapping("/num")
    @ResponseBody
    int home(){
        int i = iuser.getIntUser();
        return i;
    }

    @RequestMapping("/getUser")
    @ResponseBody
    List<UserInfo> getUser(){
        return iuser.getAllUser();
    }
}