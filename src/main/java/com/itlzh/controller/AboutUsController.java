package com.itlzh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/AboutUs")
public class AboutUsController {

    @RequestMapping(value = "/main.do")
    public String mainDo() {
        return "about-us";
    }
}
