package com.kjiao.devops.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kjiao on 13/04/2017.
 */
@Controller
public class CopyController {

    @RequestMapping("/about")
    public String about() {
        return "copy/about";
    }
}
