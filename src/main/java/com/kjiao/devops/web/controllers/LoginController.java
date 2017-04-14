package com.kjiao.devops.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kjiao on 14/04/2017.
 */
@Controller
public class LoginController {

    private final static String LOGIN_VIEW_NAME = "user/login";

    @RequestMapping("/login")
    public String login() {
        return LOGIN_VIEW_NAME;
    }
}
