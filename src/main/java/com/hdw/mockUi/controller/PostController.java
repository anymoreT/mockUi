package com.hdw.mockUi.controller;

import com.hdw.mockUi.entity.UserInfo;
import com.hdw.mockUi.service.impl.UserInterFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private UserInterFace iuser;

    @RequestMapping(value="/testInsertUser", method = RequestMethod.POST)
    public @ResponseBody
    void testInserUser( @RequestBody  UserInfo user){

        iuser.testInsertUser("1","2");

    }
}
