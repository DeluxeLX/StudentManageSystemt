package com.itlzh.controller;

import cn.hutool.json.JSONArray;
import com.itlzh.pojo.Course;
import com.itlzh.pojo.CourseTable;
import com.itlzh.pojo.Score;
import com.itlzh.service.CourseService;
import com.utils.transformationID.IDTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping(value = "/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/findAllCourse.do")
    public ModelAndView findAllCourse() {
        ModelAndView mav = new ModelAndView();
        List<Course> courseList = courseService.findAllCourse();
        mav.addObject("courseList", courseList);
        mav.setViewName("courseList");
        return mav;
    }

    @RequestMapping(value = "/selectCourse.do")
    public ModelAndView selectCourse(String courseId) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("courseList");

        System.out.println("进入到selectCourse.do...中");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String studentName = auth.getName();
        System.out.println(studentName);
        String studentId = courseService.findStuIdByName(studentName);
        System.out.println(studentId);
        int selectCount = courseService.findCourseCount(studentId);

        // 先判断课程是否还有空闲座位
        Course course = courseService.findCourseByCId(courseId);
        int vacantSeats = course.getVacantSeats();
        if (vacantSeats == 0) {
            mav.addObject("checkResult", "这门课选课人数已满...");
            return mav;
        }

        // 再判断学生选课是否达到上限
        if (selectCount == 5) {
            mav.addObject("checkResult", "您的选课已达上限（最多5门）");
            return mav;
        }

        // 再判断选择的课是否已经选择过
        CourseTable courseTable = courseService.findCourseTableByOneStudent(studentId);
        if (courseTable != null) {
            List<Course> courseList = courseTable.getCourseList();
            for (Course course1: courseList) {
                if (course1.getId().equalsIgnoreCase(courseId)) {
                    mav.addObject("checkResult", "这门课已经选择过了，请勿重复选课...");
                    return mav;
                }
            }
        }

        // 再插入至"多对多"表中表示选课成功
        int count = courseService.addSelectCourse(studentId, courseId);
        int count1 = courseService.updateCourseCount(studentId);
        int count2 = courseService.updateVacantSeatsInt(courseId);
        System.out.println(count + count1 + count2);

        mav.addObject("checkResult", "选课成功！");
        return mav;
    }

    @RequestMapping(value = "/courseTable.do")
    public ModelAndView courseTable() {
        ModelAndView mav = new ModelAndView();
        System.out.println("进入到courseTable.do...中");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String studentName = auth.getName();
        String studentId = courseService.findStuIdByName(studentName);

        CourseTable courseTable = courseService.findCourseTableByOneStudent(studentId);

        if (courseTable != null) {
            List<Course> courseList = courseTable.getCourseList();
            String courseNameStr = null;
            for (Course course2: courseList) {

                courseNameStr = IDTransformation.courseName2JspStr(course2.getClassTime());
                mav.addObject(courseNameStr, course2.getName() + "/" + course2.getTeacherObj().getName() + "/" + course2.getClassroom());
            }
        }

        mav.setViewName("courseTable");
        return mav;
    }

    @RequestMapping(value = "/findAllScoreByOneStudent.do")
    public ModelAndView findAllScoreByOneStudent() {
        ModelAndView mav = getOneStuScore();
        mav.setViewName("score");
        return mav;
    }

    @RequestMapping(value = "/oneStuScorePrint.do")
    public ModelAndView oneStuScorePrint() {
        ModelAndView mav = getOneStuScore();
        mav.setViewName("studentOneScorePrint");
        return mav;
    }

    private ModelAndView getOneStuScore() {
        ModelAndView mav = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String studentName = auth.getName();
        String studentId = courseService.findStuIdByName(studentName);
        Date date = new Date();

        int gpa = 0;
        List<Score> scoreList = courseService.findAllScoreByOneStudent(studentId);

        List<Map<String, String>> dataList = new ArrayList<>();
        int allCredit = courseService.creditHourTotalBySid(studentId);

        for (Score score: scoreList) {
            if (score.getScore() != null) {
                Map<String, String> dataMap = new HashMap<>();
                gpa = gpa + score.getScore() * score.getCredit_hour();
                Double scoreCredit = (double)score.getScore() * score.getCredit_hour() / allCredit;
                long scoreCreditRound = Math.round(scoreCredit);
                System.out.println(scoreCreditRound);
                dataMap.put("label", score.getCourseName());
                dataMap.put("value", Long.toString(scoreCreditRound));
                dataList.add(dataMap);
            }
        }

        JSONArray jsonArray = new JSONArray(dataList);
        System.out.println(jsonArray);
        System.out.println(dataList);

        gpa = gpa / allCredit;
        mav.addObject("studentGPA", gpa);
        mav.addObject("scoreList", scoreList);
        mav.addObject("dateNow", date);
        mav.addObject("dataListMap", jsonArray);
        return mav;
    }
}
