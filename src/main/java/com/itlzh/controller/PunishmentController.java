package com.itlzh.controller;

import com.itlzh.pojo.Punishment;
import com.itlzh.service.PunishmentService;
import com.utils.transformationID.IDTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/punishment")
public class PunishmentController {

    @Autowired
    PunishmentService punishmentService;

    @RequestMapping(value = "/findAllPunishment.do")
    public ModelAndView findAllPunishment() {
        ModelAndView mav = new ModelAndView();
        List<Punishment> punishmentList = punishmentService.findAllPunishment();
        IDTransClassAndDep(punishmentList);
        if (punishmentList.size() == 0) {
            mav.addObject("checkResult", "未查询到相关信息...");
        }
        mav.addObject("studentPunishmentList", punishmentList);
        mav.setViewName("studentPunishmentList");
        return mav;
    }

    @RequestMapping(value = "/addPunishment.do")
    public String addPunishment(Punishment punishment) {
        String checkResult = null;
        Date date = new Date();
        int punishmentLevel = IDTransformation.punishmentStr2punishmentLevel(punishment.getPunishLevelStr());
        punishment.setPunishLevel(punishmentLevel);
        punishment.setRecTime(date);

        System.out.println(punishment);

        System.out.println("进入到了addPunishment.do...");
        int count = punishmentService.addPunishment(punishment);
        System.out.println(count);

        return "redirect:findAllPunishment.do";
    }

    @RequestMapping(value = "/updatePunishmentPage.do")
    public ModelAndView updatePunishmentPage(String studentId) {
        ModelAndView mav = new ModelAndView();
        Punishment punishment = punishmentService.findOnePunishment(studentId);
        System.out.println(punishment);

        mav.addObject("studentPunishment", punishment);
        mav.setViewName("punishmentUpdate");
        return mav;
    }

    @RequestMapping(value = "/updatePunishment.do")
    public String updatePunishment(Punishment punishment) {

        System.out.println("进入到了updatePunishment.do...中");
        System.out.println(punishment);
        int punishmentLevel = IDTransformation.punishmentStr2punishmentLevel(punishment.getPunishLevelStr());
        punishment.setPunishLevel(punishmentLevel);
        punishment.setRecTime(new Date());
        int count = punishmentService.updatePunishment(punishment);
        System.out.println(count);

        return "redirect:findAllPunishment.do";
    }

    @RequestMapping(value = "/deletePunishment.do")
    public String deletePunishment(String studentId) {
        int count = punishmentService.deletePunishment(studentId);
        System.out.println(count);
        return "redirect:findAllPunishment.do";
    }

    @RequestMapping(value = "/findPunishmentByClass.do")
    public ModelAndView findPunishmentByClass(String className) {
        ModelAndView mav = new ModelAndView();

        String classId = IDTransformation.className2classId(className);
        List<Punishment> punishmentList = punishmentService.findPunishmentByClass(classId);
        IDTransClassAndDep(punishmentList);

        mav.addObject("studentPunishmentList", punishmentList);
        mav.setViewName("studentPunishmentList");
        return mav;
    }

    @RequestMapping(value = "/findPunishmentByLevel.do")
    public ModelAndView findPunishmentByLevel(String punishLevelStr) {
        ModelAndView mav = new ModelAndView();

        int punishmentLevel = IDTransformation.punishmentStr2punishmentLevel(punishLevelStr);
        List<Punishment> punishmentList = punishmentService.findAllPunishmentByLevel(punishmentLevel);
        IDTransClassAndDep(punishmentList);

        mav.addObject("studentPunishmentList", punishmentList);
        mav.setViewName("studentPunishmentList");
        return mav;
    }

    private void IDTransClassAndDep(List<Punishment> punishmentList) {
        for (Punishment punishment: punishmentList) {
            String classId1 = punishment.getOneStudent().getClassId();
            String departmentId = punishment.getOneStudent().getDepartmentId();
            String className = IDTransformation.classId2className(classId1);
            String departmentName = IDTransformation.departmentId2departmentName(departmentId);
            punishment.getOneStudent().setClassId(className);
            punishment.getOneStudent().setDepartmentId(departmentName);
        }
    }
}
