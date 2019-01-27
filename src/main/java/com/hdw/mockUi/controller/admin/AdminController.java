package com.hdw.mockUi.controller.admin;

import com.hdw.mockUi.entity.UserInfo;
import com.hdw.mockUi.service.IUserInterFace;
import com.hdw.mockUi.utils.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private IUserInterFace iuser;

    @RequestMapping("/sayHello")
    @ResponseBody
    String home(){
        Integer userid = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userSession");
        return "admin,session,hello";
    }

    @RequestMapping("/getUser")
    @ResponseBody
    List<UserInfo> getUser(){
        return iuser.getAllUser();
    }

    @RequestMapping("/addRoles")
    String addRoles(){
        return "admin/roleList";
    }

    @RequestMapping("/getRolesList")
    @ResponseBody
    String getRolesList(){
        String jsonStr = FileUtils.getStreamFromFile("data/json.data");
        return jsonStr;
       // return iuser.getAllUser();
    }
}
