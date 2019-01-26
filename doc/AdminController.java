package com.hdw.mockUi.controller.noUser.shiroController;

import org.apache.ibatis.mapping.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//管理员
@RestController
@RequestMapping("/admin")
public class AdminController {


    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public ResultMap getMessage() {
        return "您拥有管理员权限，可以获得该接口的信息！";
    }
}