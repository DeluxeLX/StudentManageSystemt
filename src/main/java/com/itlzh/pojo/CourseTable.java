package com.itlzh.pojo;

import java.util.List;

public class CourseTable {

    private String studentId;
    private int selectCourseCount;

    private List<Course> courseList;

    public CourseTable() {}

    public CourseTable(String studentId, int selectCourseCount, List<Course> courseList) {
        this.studentId = studentId;
        this.selectCourseCount = selectCourseCount;
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "CourseTable{" +
                "studentId='" + studentId + '\'' +
                ", selectCourseCount=" + selectCourseCount +
                ", courseList=" + courseList +
                '}';
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getSelectCourseCount() {
        return selectCourseCount;
    }

    public void setSelectCourseCount(int selectCourseCount) {
        this.selectCourseCount = selectCourseCount;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
