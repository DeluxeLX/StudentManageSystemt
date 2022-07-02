package com.itlzh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(value = "/CheckUser.do")
    public ModelAndView CheckUser() {
        ModelAndView mav = new ModelAndView();

        String str = "用户名或密码有误，请重新输入...";

        mav.addObject("CheckUserResult", str);
        mav.setViewName("login");
        return mav;
    }
}
