package com.itlzh.controller;

import com.itlzh.pojo.Course;
import com.itlzh.pojo.Score;
import com.itlzh.pojo.Student;
import com.itlzh.service.CourseService;
import com.itlzh.service.EducationService;
import com.itlzh.service.TeacherService;
import com.utils.pojoTable.teaStudentTable;
import com.utils.transformationID.IDTransformation;
import com.utils.exportTable.execlTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    CourseService courseService;

    @Autowired
    EducationService educationService;

    private String globalCourseId;

    @RequestMapping(value = "/findCourseBySelf.do")
    public ModelAndView findCourseBySelf() {
        ModelAndView mav = new ModelAndView();
        String teacherId = this.getTeaIdByName();
        List<Course> courseList = teacherService.findCourseBySelf(teacherId);

        mav.addObject("courseList", courseList);
        mav.setViewName("teaCourseList");
        return mav;
    }

    @RequestMapping(value = "/addTeaCourse.do")
    public ModelAndView addTeaCourse(Course course) {
        ModelAndView mav = new ModelAndView();

        System.out.println("进入addTeaCourse.do...中");
        System.out.println(course);
        course.setId("0");
        course.setTeacherId(getTeaIdByName());
        int count = teacherService.addTeaCourse(course);
        System.out.println(count);

        mav.setViewName("redirect:findCourseBySelf.do");
        return mav;
    }

    @RequestMapping(value = "/deleteCourse.do")
    public ModelAndView deleteCourse(String courseId) {
        ModelAndView mav = new ModelAndView();
        Course course = teacherService.findCourseByCid(courseId);
        if (course.getState() != 3) {
            mav.addObject("checkResult", "教务处未审批，不能重复执行课程操作！");
            mav.setViewName("teaCourseList");
            return mav;
        }
        System.out.println("进入到了deleteCourse.do...中");
        int count = teacherService.deleteTeaCourse(courseId);
        System.out.println(count);

        mav.setViewName("redirect:findCourseBySelf.do");
        return mav;
    }

    @RequestMapping(value = "/updateCoursePage.do")
    public ModelAndView updateCoursePage(String courseId) {
        ModelAndView mav = new ModelAndView();

        Course course = teacherService.findCourseByCid(courseId);
        globalCourseId = courseId;
        if (course.getState() != 3) {
            mav.addObject("checkResult", "教务处未审批，不能重复执行课程操作！");
            mav.setViewName("teaCourseList");
            return mav;
        }
        System.out.println(course);

        mav.addObject("courseDetail", course);
        mav.setViewName("courseUpdate");
        return mav;
    }

    @RequestMapping(value = "/updateTeaCourse.do")
    public String updateCourse(Course course) {
        System.out.println("进入到updateTeaCourse.do...");
        int state = IDTransformation.courseStateStr2State(course.getStateStr());
        course.setId(globalCourseId);
        course.setTeacherId(getTeaIdByName());
        course.setState(state);

        int count = teacherService.updateTeaCourse(course);
        System.out.println(course);
        System.out.println(count);
        return "redirect:findCourseBySelf.do";
    }

    @RequestMapping(value = "/findAllStuByCid.do")
    public ModelAndView findAllStuByCid(String courseId) {
        ModelAndView mav = new ModelAndView();

        List<Student> studentList = teacherService.findAllStuByCid(courseId);
        globalCourseId = courseId;
        for (Student student: studentList) {
            student.setClassId(IDTransformation.classId2className(student.getClassId()));
            student.setDepartmentId(IDTransformation.departmentId2departmentName(student.getDepartmentId()));
        }

        mav.addObject("studentList", studentList);
        mav.setViewName("teaStudentList");
        return mav;
    }

    @RequestMapping(value = "/exportAllTeaStu.do")
    public void exportAllTeaStu(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Student> studentList = teacherService.findAllStuByCid(globalCourseId);
        if (studentList.size() != 0) {
            List<teaStudentTable> studentTables = new ArrayList<>();
            for (Student student: studentList) {
                String studentId = student.getStudentId();
                String name = student.getName();
                String sex = student.getSex();
                String departmentName = IDTransformation.departmentId2departmentName(student.getDepartmentId());
                String className = IDTransformation.classId2className(student.getClassId());
                teaStudentTable teaTable = new teaStudentTable(studentId, name, sex, departmentName, className);
                studentTables.add(teaTable);
            }
            execlTable<teaStudentTable> et = new execlTable<>();
            String[] headers = {"学号", "姓名", "性别", "学院", "班级"};
            String fileName = "学员名单";
            et.exportExcel(headers, studentTables, fileName, response);
        }
    }

    @RequestMapping(value = "/findScoreList.do")
    public ModelAndView findScoreList() {
        ModelAndView mav = new ModelAndView();
        String teacherId = this.getTeaIdByName();
        List<Course> courseList = teacherService.findIsSelectCourseByTid(teacherId);

        mav.addObject("courseList", courseList);
        mav.setViewName("teaScoreCourseList");
        return mav;
    }

    @RequestMapping(value = "/inputScorePage.do")
    public ModelAndView inputScorePage(String courseId) {
        ModelAndView mav = new ModelAndView();

        List<Student> studentList = teacherService.findAllStuByCid(courseId);
        List<Score> scoreList = educationService.findScoreByCid(courseId);
        for (int i=0; i<studentList.size(); i++) {
            studentList.get(i).setDepartmentId(IDTransformation.departmentId2departmentName(studentList.get(i).getDepartmentId()));
            studentList.get(i).setClassId(IDTransformation.classId2className(studentList.get(i).getClassId()));
            studentList.get(i).setScore(scoreList.get(i).getScore());
        }
        globalCourseId = courseId;

        mav.addObject("studentList", studentList);
        mav.setViewName("teaStudentGradeList");
        return mav;
    }

    @RequestMapping(value = "/inputAllStuScore.do")
    public ModelAndView inputAllStuScore(int[] score) {
        ModelAndView mav = new ModelAndView();
        if (score.length == 0) {
            mav.addObject("checkResult", "添加错误");
            mav.setViewName("teaStudentGradeList");
            return mav;
        }

        List<Student> studentList = teacherService.findAllStuByCid(globalCourseId);
        List<Score> scoreList = new ArrayList<>();

        for (int i=0; i<studentList.size(); i++) {
            String studentId = studentList.get(i).getStudentId();
            Score scoreObj = new Score();
            scoreObj.setScore(score[i]);
            scoreObj.setCourseName(globalCourseId);
            scoreObj.setStudentId(studentId);
            scoreList.add(scoreObj);
        }
        System.out.println(scoreList);
        int count = teacherService.addAllStuScore(scoreList);
        System.out.println(count);

        mav.addObject("checkResult", "添加成绩成功");
        mav.setViewName("teaStudentGradeList");
        return mav;
    }

    public String getTeaIdByName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String teacherName = auth.getName();
        return teacherService.findTidByTName(teacherName);
    }
}
