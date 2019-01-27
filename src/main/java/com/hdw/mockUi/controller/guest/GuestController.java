package com.hdw.mockUi.controller.guest;


import com.hdw.mockUi.entity.UserInfo;
import com.hdw.mockUi.service.AuthImpl.ShiroAuthImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "guest")
@Controller
public class GuestController {
    @Autowired
    ShiroAuthImpl shiroAuthImpl;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
       return "guest/home";
    }
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "guest/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("user", new UserInfo());
        return "guest/login";
    }

    //通过界面的form获取的用户名核密码，用于鉴权
    @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
    public String checkUser(UserInfo user) {
        shiroAuthImpl.login(user.getPsname(), user.getCardno());
      //  return "common/success";
        return "admin/roleList";
    }

}
