package com.itlzh.controller;

import com.itlzh.pojo.Course;
import com.itlzh.pojo.Score;
import com.itlzh.pojo.Student;
import com.itlzh.pojo.refuseReason;
import com.itlzh.service.CourseService;
import com.itlzh.service.EducationService;
import com.itlzh.service.StudentService;
import com.utils.exportTable.execlTable;
import com.utils.pojoTable.eduAllCourseTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/education")
public class EducationController {

    @Autowired
    EducationService educationService;

    @Autowired
    CourseService courseService;

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/findCourseByApply.do")
    public ModelAndView findCourseByApply() {
        ModelAndView mav = new ModelAndView();

        List<Course> courseList = educationService.findCourseByApply();
        mav.addObject("courseList", courseList);
        mav.setViewName("eduCourseList");
        return mav;
    }

    @RequestMapping(value = "/agreeApplication.do")
    public ModelAndView agreeApplication(String courseId) {
        ModelAndView mav = new ModelAndView();

        int count = educationService.agreeApplication(courseId);
        System.out.println(count);
        mav.addObject("checkResult", "同意申请！");
        mav.setViewName("eduCourseList");
        return mav;
    }

    @RequestMapping(value = "/refuseReasonPage.do")
    public ModelAndView refuseApplication(String courseId) {
        ModelAndView mav = new ModelAndView();

        String courseName = courseService.findCourseByCId(courseId).getName();

        mav.addObject("courseId", courseId);
        mav.addObject("courseName", courseName);
        mav.setViewName("refuseReason");
        return mav;
    }

    @RequestMapping(value = "/addRefuse.do")
    public ModelAndView addRefuse(refuseReason reason) {
        ModelAndView mav = new ModelAndView();

        System.out.println(reason);
        System.out.println("进入到addRefuse.do...");
        int count = educationService.addRefuseReason(reason);
        System.out.println(count);

        Course course = courseService.findCourseByCId(reason.getCourseId());
        course.setState(6);
        System.out.println(course);
        int count1 = courseService.updateCourseState(course);
        System.out.println(count1);

        mav.setViewName("redirect:findCourseByApply.do");
        return mav;
    }

    @RequestMapping(value = "/findAllCourseList.do")
    public ModelAndView findAllCourseList() {
        ModelAndView mav = new ModelAndView();

        List<Course> courseList = courseService.findAllCourse();
        mav.addObject("courseList", courseList);
        mav.setViewName("eduAllCourseList");
        return mav;
    }

    @RequestMapping(value = "/exportEduAllCourse.do")
    public void exportEduAllCourse(HttpServletRequest request, HttpServletResponse response) {
        List<Course> courseList = courseService.findAllCourse();
        if (courseList.size() != 0) {
            List<eduAllCourseTable> tables = new ArrayList<>();
            for (Course course: courseList) {
                String courseId = course.getId();
                String courseName = course.getName();
                String teacherName = course.getTeacherObj().getName();
                int credit_hour = course.getCredit_hour();
                int period = course.getPeriod();
                String classTime = course.getClassTime();
                String classroom = course.getClassroom();
                int vacantSeats = course.getVacantSeats();
                String state = course.getStateStr();
                eduAllCourseTable table = new eduAllCourseTable(courseId, courseName, teacherName, credit_hour, period, classTime, classroom, vacantSeats, state);
                tables.add(table);
            }
            execlTable<eduAllCourseTable> et = new execlTable<>();
            String[] headers = {"课程号", "课程名", "教师", "学分", "学时", "上课时间", "上课教室", "空闲座位" , "课程状态"};
            String fileName = "课程安排表";
            et.exportExcel(headers, tables, fileName, response);
        }
    }

    @RequestMapping(value = "/toPrintPage.do")
    public ModelAndView toPrintPage(String courseId) {
        ModelAndView mav = new ModelAndView();
        Date date = new Date();

        Course course = courseService.findCourseByCId(courseId);
        List<Score> scoreList = educationService.findScoreByCid(courseId);
        for (Score score: scoreList) {
            Student student = studentService.findOneStudent(score.getStudentId());
            score.setStudentName(student.getName());
        }

        mav.addObject("scoreList", scoreList);
        mav.addObject("courseName", course.getName());
        mav.addObject("dateNow", date);
        mav.setViewName("scorePrint");
        return mav;
    }
}
