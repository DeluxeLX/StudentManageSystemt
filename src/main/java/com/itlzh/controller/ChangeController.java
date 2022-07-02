package com.itlzh.controller;

import com.itlzh.pojo.Change;
import com.itlzh.service.ChangeService;
import com.utils.transformationID.IDTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/change")
public class ChangeController {

    @Autowired
    ChangeService changeService;

    @RequestMapping(value = "/findAllChange.do")
    public ModelAndView findAllChange() {
        ModelAndView mav = new ModelAndView();
        List<Change> changeList = changeService.findAllChange();
        IDTransClassAndDep(changeList);
        if (changeList.size() == 0) {
            mav.addObject("checkResult", "未查询到相关信息...");
        }
        mav.addObject("studentChangeList", changeList);
        mav.setViewName("studentChangeList");
        return mav;
    }

    @RequestMapping(value = "/addChange.do")
    public String addChange(Change change) {
        String checkResult = null;
        Date date = new Date();
        int changeLevel = IDTransformation.changeStr2changeLevel(change.getChangeLevelStr());
        change.setChangeLevel(changeLevel);
        change.setRecTime(date);

        System.out.println(change);

        System.out.println("进入到了addChange.do...");
        int count = changeService.addChange(change);
        System.out.println(count);

        return "redirect:findAllChange.do";
    }

    @RequestMapping(value = "/updateChangePage.do")
    public ModelAndView updateChangePage(String studentId) {
        ModelAndView mav = new ModelAndView();
        Change change = changeService.findOneChange(studentId);
        System.out.println(change);

        mav.addObject("studentChange", change);
        mav.setViewName("changeUpdate");
        return mav;
    }

    @RequestMapping(value = "/updateChange.do")
    public String updateChange(Change change) {

        System.out.println("进入到了updateChange.do...中");
        System.out.println(change);
        int changeLevel = IDTransformation.changeStr2changeLevel(change.getChangeLevelStr());
        change.setChangeLevel(changeLevel);
        change.setRecTime(new Date());
        int count = changeService.updateChange(change);
        System.out.println(count);

        return "redirect:findAllChange.do";
    }

    @RequestMapping(value = "/deleteChange.do")
    public String deleteChange(String studentId) {
        int count = changeService.deleteChange(studentId);
        System.out.println(count);
        return "redirect:findAllChange.do";
    }

    @RequestMapping(value = "/findChangeByClass.do")
    public ModelAndView findChangeByClass(String className) {
        ModelAndView mav = new ModelAndView();

        String classId = IDTransformation.className2classId(className);
        List<Change> changeList = changeService.findChangeByClass(classId);
        IDTransClassAndDep(changeList);

        mav.addObject("studentChangeList", changeList);
        mav.setViewName("studentChangeList");
        return mav;
    }

    @RequestMapping(value = "/findChangeByLevel.do")
    public ModelAndView findChangeByLevel(String changeLevelStr) {
        ModelAndView mav = new ModelAndView();

        int changeLevel = IDTransformation.changeStr2changeLevel(changeLevelStr);
        List<Change> changeList = changeService.findAllChangeByLevel(changeLevel);
        IDTransClassAndDep(changeList);

        mav.addObject("studentChangeList", changeList);
        mav.setViewName("studentChangeList");
        return mav;
    }

    private void IDTransClassAndDep(List<Change> changeList) {
        for (Change change: changeList) {
            String classId1 = change.getOneStudent().getClassId();
            String departmentId = change.getOneStudent().getDepartmentId();
            String className = IDTransformation.classId2className(classId1);
            String departmentName = IDTransformation.departmentId2departmentName(departmentId);
            change.getOneStudent().setClassId(className);
            change.getOneStudent().setDepartmentId(departmentName);
        }
    }
}
