package com.hdw.mockUi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    @GetMapping("login")
    public String login(HttpServletRequest request) {
        LOGGER.info("跳到这边的路径为:"+request.getRequestURI());
        return "login_new";

    }
}
