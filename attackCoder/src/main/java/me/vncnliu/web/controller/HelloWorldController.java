package me.vncnliu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Copyright (c) 2008 by sangame.com.
 * All right reserved.
 * Created by liuyaqing@sangame.com on 2016/4/8.
 */
@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    public String hello(@RequestParam(value="name", defaultValue="World") String name) {
        return "hello";
    }
}
