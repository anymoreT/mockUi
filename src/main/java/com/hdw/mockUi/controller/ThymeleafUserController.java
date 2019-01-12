package com.hdw.mockUi.controller;

import com.hdw.mockUi.entity.UserInfo;
//import com.hdw.mockUi.service.IUserInterFace;
import com.hdw.mockUi.service.impl.UserInterFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/user")
public class ThymeleafUserController {
    @Autowired
    private UserInterFace iuser;

    @GetMapping("/userlist")
    public String userList(Model model){

        model.addAttribute("contents",iuser.getAllUser());
        return "/user/userlist";
    }

    @GetMapping("/form")
    public String form(Model model){

        model.addAttribute("user" , new UserInfo());
        return "/user/form";
    }

    @GetMapping("{id}")
    public String userview(@PathVariable("id") int id , Model model){
        UserInfo user = iuser.getUserById(id);
        model.addAttribute("user",user);
        return "/user/userview";
    }

    @PostMapping("savaUser")
    public String saveUser(UserInfo user){
        if(user.getId()==0){
            iuser.testInsertUser(user.getCardno(),user.getPsname());

        }else{
            int a = iuser.updateById(user.getId(),user.getCardno(),user.getPsname());
        }
        return "/common/success";
    }

   @RequestMapping(value="/testInsertUser", method = RequestMethod.POST)
    public @ResponseBody void testInserUser(@RequestBody UserInfo user){
       iuser.testInsertUser(user.getCardno(),user.getPsname());
    }

    @GetMapping(value = "edit/{id}")
    public String editForm(@PathVariable("id") int id , Model model){
        UserInfo user = iuser.getUserById(id);
        model.addAttribute("user" , user);
        return "/user/form";
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") int id){
        iuser.deleteById(id);
        return "/common/success";
    }
}
