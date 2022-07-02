package com.itlzh.pojo;

import java.util.List;

public class Course {

    private String id;
    private String name;

    private String teacherId;
    private Teacher teacherObj;           // 课程与教师，多对一，一个老师可以上多门课，一门课只有一个老师

    private int credit_hour;
    private String credit_hourStr;

    private int period;
    private String periodStr;

    private String classTime;
    private String classroom;
    private String intro;

    private int state;
    private String stateStr;
    private courseState courseStateObj;   // 一对一

    private int vacantSeats;

    private List<Student> studentList;    // 课程与学生，多对多，一个学生有多门课，一门课有多个学生

    public Course() {}

    public Course(String id, String name, String teacherId, int credit_hour, int period, String classTime, String classroom, String intro, int state, int vacantSeats) {
        this.id = id;
        this.name = name;
        this.teacherId = teacherId;
        this.credit_hour = credit_hour;
        this.period = period;
        this.classTime = classTime;
        this.classroom = classroom;
        this.intro = intro;
        this.state = state;
        this.vacantSeats = vacantSeats;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", teacherObj=" + teacherObj +
                ", credit_hour=" + credit_hour +
                ", credit_hourStr='" + credit_hourStr + '\'' +
                ", period=" + period +
                ", periodStr='" + periodStr + '\'' +
                ", classTime='" + classTime + '\'' +
                ", classroom='" + classroom + '\'' +
                ", intro='" + intro + '\'' +
                ", state=" + state +
                ", stateStr='" + stateStr + '\'' +
                ", courseStateObj=" + courseStateObj +
                ", vacantSeats=" + vacantSeats +
                ", studentList=" + studentList +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public Teacher getTeacherObj() {
        return teacherObj;
    }

    public void setTeacherObj(Teacher teacherObj) {
        this.teacherObj = teacherObj;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public int getCredit_hour() {
        return credit_hour;
    }

    public void setCredit_hour(int credit_hour) {
        this.credit_hour = credit_hour;
    }

    public String getCredit_hourStr() {
        return credit_hourStr;
    }

    public void setCredit_hourStr(String credit_hourStr) {
        this.credit_hourStr = credit_hourStr;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getPeriodStr() {
        return periodStr;
    }

    public void setPeriodStr(String periodStr) {
        this.periodStr = periodStr;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateStr() {
        return stateStr;
    }

    public void setStateStr(String stateStr) {
        this.stateStr = stateStr;
    }

    public courseState getCourseStateObj() {
        return courseStateObj;
    }

    public void setCourseStateObj(courseState courseStateObj) {
        this.courseStateObj = courseStateObj;
    }

    public int getVacantSeats() {
        return vacantSeats;
    }

    public void setVacantSeats(int vacantSeats) {
        this.vacantSeats = vacantSeats;
    }
}
