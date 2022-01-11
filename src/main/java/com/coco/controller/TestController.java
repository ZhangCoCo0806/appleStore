package com.coco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/vip1page")
    public String vip1page(Model model){
        model.addAttribute("vip","会员1");
        return "vipTest";
    }
    @RequestMapping("/vip2page")
    public String vip2page(Model model){
        model.addAttribute("vip","会员2");
        return "vipTest";
    }
    @RequestMapping("/vip3page")
    public String vip3page(Model model){
        model.addAttribute("vip","会员3");
        return "vipTest";
    }
}
