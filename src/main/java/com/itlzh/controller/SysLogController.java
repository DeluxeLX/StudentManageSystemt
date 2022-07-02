package com.itlzh.controller;

import com.itlzh.pojo.SysLog;
import com.itlzh.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping(value = "/sysLog")
@Controller
public class SysLogController {

    @Autowired
    ISysLogService sysLogService;

    @RequestMapping(value = "/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mav = new ModelAndView();
        List<SysLog> sysLogs = sysLogService.findAll();
        mav.addObject("sysLogs", sysLogs);
        mav.setViewName("syslog-list");
        return mav;
    }

}
