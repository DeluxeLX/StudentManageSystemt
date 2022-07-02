package com.itlzh.controller;

import com.itlzh.pojo.Change;
import com.itlzh.pojo.Punishment;
import com.itlzh.pojo.Reward;
import com.itlzh.pojo.Student;
import com.itlzh.service.ChangeService;
import com.itlzh.service.PunishmentService;
import com.itlzh.service.RewardService;
import com.itlzh.service.StudentService;
import com.utils.transformationID.IDTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    StudentService studentService;  // 学生功能

    @Autowired
    ChangeService changeService;    // 学生学籍变更功能

    @Autowired
    RewardService rewardService;    // 学生奖励功能

    @Autowired
    PunishmentService punishmentService;   // 学生处罚功能

    @RequestMapping(value = "/addStudent.do")
    public String addStudent(Student student) {

        System.out.println("进入到addStudent.do映射里来了");
        String className = student.getClassId();             // 现在传过来的是className
        String departmentName = student.getDepartmentId();   // 现在传过来的是departmentName
        String classId = IDTransformation.className2classId(className);
        String departmentId = IDTransformation.departmentName2departmentId(departmentName);
        student.setClassId(classId);
        student.setDepartmentId(departmentId);

        System.out.println(student);
        if (student.getName().equals("") || student.getStudentId().equals("") || student.getName() == null || student.getStudentId() == null) {
            return "redirect:errorStudentAdd.do";
        }

        Student student1 = studentService.findOneStudent(student.getStudentId());
        if (student1 != null) {
            return "redirect:errorStudentAddByPK.do";
        }

        int count = studentService.addStudent(student);
        System.out.println(count);

        return "redirect:findAllStudent.do";
    }

    @RequestMapping(value = "/errorStudentAdd.do")
    public ModelAndView errorStudentAdd() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("errorStudentAddMsg", "学号或姓名不能为空！！！");
        mav.setViewName("studentAdd");
        return mav;
    }

    @RequestMapping(value = "/errorStudentAddByPK.do")
    public ModelAndView errorStudentAddByPK() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("errorStudentAddMsg", "已存在此学号，不能重复添加！！！");
        mav.setViewName("studentAdd");
        return mav;
    }

    @RequestMapping(value = "/findAllStudent.do")
    public ModelAndView findAllStudent() {
        ModelAndView mav = new ModelAndView();
        List<Student> studentList = studentService.findAllStudent();
        mav.addObject("studentList", studentList);
        mav.setViewName("studentList");
        return mav;
    }

    @RequestMapping(value = "/findOneStudent.do")
    public ModelAndView findOneStudent(String studentId) {
        ModelAndView mav = new ModelAndView();

        System.out.println("进入到详情页面来啦。。。");
        System.out.println(studentId);
        Student student = studentService.findOneStudent(studentId);
        Change change = changeService.findOneChange(studentId);
        Reward reward = rewardService.findOneReward(studentId);
        Punishment punishment = punishmentService.findOnePunishment(studentId);

        mav.addObject("studentDetails", student);
        mav.addObject("changeDetails", change);
        mav.addObject("rewardDetails", reward);
        mav.addObject("punishmentDetails", punishment);
        mav.setViewName("studentDetails");
        return mav;
    }

    @RequestMapping(value = "/updateStudentPage.do")
    public ModelAndView updateStudentPage(String studentId) {
        ModelAndView mav = new ModelAndView();
        Student student = studentService.findOneStudent(studentId);
        mav.addObject("student", student);
        mav.setViewName("studentUpdate");
        return mav;
    }

    @RequestMapping(value = "/updateStudent.do")
    public String updateStudent(Student student) {

        System.out.println("进入到updateStudent.do映射里来了");
        String className = student.getClassId();             // 现在传过来的是className
        String departmentName = student.getDepartmentId();   // 现在传过来的是departmentName
        String classId = IDTransformation.className2classId(className);
        String departmentId = IDTransformation.departmentName2departmentId(departmentName);
        student.setClassId(classId);
        student.setDepartmentId(departmentId);

        System.out.println(student);
        if (student.getName().equals("") || student.getStudentId().equals("") || student.getName() == null || student.getStudentId() == null) {
            return "redirect:errorStudentUpdate.do";
        }

        int count = studentService.updateStudent(student);
        System.out.println(count);

        return "redirect:findAllStudent.do";
    }

    @RequestMapping(value = "/errorStudentUpdate.do")
    public ModelAndView errorStudentUpdate() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("errorStudentUpdateMsg", "学号或姓名不能为空！！！");
        mav.setViewName("studentUpdate");
        return mav;
    }

    @RequestMapping(value = "/deleteStudent.do")
    public String deleteStudent(String studentId) {

        System.out.println("进入到deleteStudent.do里来了");
        System.out.println(studentId);
        int count = studentService.deleteStudent(studentId);
        System.out.println(count);

        return "redirect:findAllStudent.do";
    }

    @RequestMapping(value = "/findStudentByClass.do")
    public ModelAndView findStudentByClass(String departmentName, String className) {
        ModelAndView mav = new ModelAndView();
        String departmentId = IDTransformation.departmentName2departmentId(departmentName);
        String classId = IDTransformation.className2classId(className);
        List<Student> studentList = studentService.findStudentByClass(departmentId, classId);
        mav.addObject("studentList", studentList);
        mav.setViewName("studentList");
        return mav;
    }
}
