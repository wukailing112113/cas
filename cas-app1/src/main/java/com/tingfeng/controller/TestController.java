package com.tingfeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("/test")
public class TestController {

    @GetMapping("/test")
    public String test() {
        int a = 100;
        int b =0;
        System.out.println(a/b);
        return "test1";
    }

    @GetMapping("/test2")
    public Object test2() {
        return "redirect:http://app1.com:8181/fire/index.html";
    }

}
