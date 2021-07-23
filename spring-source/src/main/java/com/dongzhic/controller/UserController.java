package com.dongzhic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author dongzhic
 * @Date 7/21/21 3:37 PM
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/queryUser")
    public String queryUser () {
        return "jack";
    }
}
