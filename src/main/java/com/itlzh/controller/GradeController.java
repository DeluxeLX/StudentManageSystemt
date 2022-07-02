package com.itlzh.controller;

import com.itlzh.pojo.Grade;
import com.itlzh.pojo.GradeAvg;
import com.itlzh.pojo.GradeTable;
import com.itlzh.pojo.Student;
import com.itlzh.service.GradeService;
import com.itlzh.service.StudentService;
import com.utils.transformationID.IDTransformation;
import com.utils.exportTable.execlTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.utils.regexMatch.isNumber.isNum;

@Controller
@RequestMapping(value = "/Grade")
public class GradeController {

    @Autowired
    GradeService gradeService;

    @Autowired
    StudentService studentService;

    /**
     * 返回所有学生成绩
     * @return studentGradeList
     */
    @RequestMapping(value = "/findAllGrade.do")
    public ModelAndView findAllGrade() {
        ModelAndView mav = new ModelAndView();
        List<Grade> studentGradeList = gradeService.findAllGrade();
        mav.addObject("studentGradeList", studentGradeList);
        mav.setViewName("studentGradeList");
        return mav;
    }

    /**
     * 准确添加一个学生成绩
     * @return studentGradeList.jsp
     */
    @RequestMapping(value = "/addGrade.do")
    public ModelAndView addGrade(Grade grade) throws Exception{
        ModelAndView mav = new ModelAndView();
        String checkResult = null;

        System.out.println("进来了addGrade.do");
        System.out.println(grade);
        int count=0;

        if (grade.getMathGrade() == null || grade.getJavaGrade() == null || grade.getEnglishGrade() == null
                || grade.getSportGrade() == null) {
            mav.addObject("checkResult", "添加成绩错误，成绩输入框不能为空！");
            mav.setViewName("gradeAdd");
        } else {
            if (grade.getMathGrade()>100 || grade.getJavaGrade()>100 || grade.getEnglishGrade()>100 || grade.getSportGrade()>100
                    || grade.getMathGrade()<0 || grade.getJavaGrade()<0 || grade.getEnglishGrade()<0 || grade.getSportGrade()<0){
                mav.addObject("checkResult", "成绩区间在0-100之内");
                mav.setViewName("gradeAdd");
            } else {
                try {
                    count = gradeService.addGrade(grade);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (count == 0) {
                    checkResult = "添加成绩错误，不存在此学号或者此学号已有成绩！";
                    mav.addObject("checkResult", checkResult);
                    mav.setViewName("gradeAdd");
                } else {
                    List<Grade> studentGradeList = gradeService.findAllGrade();
                    mav.addObject("studentGradeList", studentGradeList);
                    mav.setViewName("studentGradeList");
                }
            }
        }
        return mav;
    }

    /**
     * 根据学生学号查询或姓名模糊查询
     */
    @RequestMapping(value = "/findOneGrade.do")
    public ModelAndView findOneGrade(String inputText) {
        ModelAndView mav = new ModelAndView();
        List<Grade> gradeList = null;

        System.out.println("进入到了findOneGrade.do");
        System.out.println(inputText);

        if (isNum(inputText)) {
            gradeList = gradeService.findOneGradeToId(inputText);
            mav.addObject("studentGradeList", gradeList);
            System.out.println(gradeList);
            if (gradeList.size() == 0) {
                System.out.println("gradeList为null");
                mav.addObject("checkResult", "您输入的学号不存在或者格式不正确");
            }
        } else {
            gradeList = gradeService.findOneGradeToName(inputText);
            mav.addObject("studentGradeList", gradeList);
            System.out.println(gradeList);
            if (gradeList.size() == 0) {
                System.out.println("gradeList为null");
                mav.addObject("checkResult", "您输入的姓名不存在");
            }
        }

        mav.setViewName("studentGradeList");
        return mav;
    }

    /**
     * 根据传来的学生ID查看学生的成绩详情
     */
    @RequestMapping(value = "/findGradeDetail.do")
    public ModelAndView findGradeDetail(String studentId) {
        ModelAndView mav = new ModelAndView();
        List<Grade> gradeList = gradeService.findOneGradeToId(studentId);

        String className = IDTransformation.classId2className(gradeList.get(0).getStudent().getClassId());
        String departmentName = IDTransformation.departmentId2departmentName(gradeList.get(0).getStudent().getDepartmentId());
        Student student = gradeList.get(0).getStudent();
        student.setClassId(className);
        student.setDepartmentId(departmentName);
        Grade grade = new Grade("0", student.getStudentId(), gradeList.get(0).getMathGrade(), gradeList.get(0).getJavaGrade(), gradeList.get(0).getEnglishGrade(), gradeList.get(0).getSportGrade(), gradeList.get(0).getStudent());

        mav.addObject("Grade", grade);
        mav.setViewName("studentGradeDetails");
        return mav;
    }

    /**
     * 删除一个学生
     */
    @RequestMapping(value = "/deleteGrade.do")
    public String deleteGrade(String studentId) {
        System.out.println("进入到deleteGrade.do...");
        System.out.println(studentId);

        int count = gradeService.deleteGrade(studentId);
        System.out.println(count);
        return "redirect:findAllGrade.do";
    }

    /**
     * 进入到编辑学生成绩页面
     */
    @RequestMapping(value = "/updateGradePage.do")
    public ModelAndView updateGradePage(String studentId) {
        ModelAndView mav = new ModelAndView();

        List<Grade> gradelist = gradeService.findOneGradeToId(studentId);
        Grade grade = gradelist.get(0);

        mav.addObject("grade", grade);
        mav.setViewName("gradeUpdate");

        return mav;
    }

    /**
     * 编辑学生信息
     */
    @RequestMapping(value = "/updateGrade.do")
    public String updateGrade(Grade grade) {

        int count = gradeService.updateGrade(grade);
        System.out.println(count);

        return "redirect:findAllGrade.do";
    }

    /**
     * 画柱状图时，只取学号和四个成绩
     */
    @RequestMapping(value = "/drawIdAndGrade.do")
    public String drawIdAndGrade() {
//        GradeAvg grade = gradeService.findAverageScores();
//        System.out.println(grade);
//        grade.setStudentId("2005040206");
//        return grade.getStudentId();
        return null;
    }

    /**
     * 生成一个报表
     */
    @RequestMapping(value = "/exportGradeTable.do")
    @ResponseBody
    public void exportGradeTable(HttpServletRequest request, HttpServletResponse response) {
        List<GradeTable> gradeList = gradeService.findAllGradeTable();
        GradeAvg gradeAvg = gradeService.findAverageScores();
        execlTable<GradeTable> et = new execlTable<>();
        String[] headers = {"学号", "姓名", "数学成绩", "Java成绩", "英语成绩", "体育成绩", "总成绩"};
        String fileName = "学生成绩表";
        et.exportExcel(headers, gradeList, fileName, response);
    }
}
