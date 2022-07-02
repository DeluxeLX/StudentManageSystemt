package com.utils.pojoTable;

public class eduAllCourseTable {

    private String courseId;
    private String className;
    private String teacherName;
    private int credit_hour;
    private int period;
    private String classTime;
    private String classroom;
    private int vacantSeats;
    private String state;

    public eduAllCourseTable() {}

    public eduAllCourseTable(String courseId, String className, String teacherName, int credit_hour, int period, String classTime, String classroom, int vacantSeats, String state) {
        this.courseId = courseId;
        this.className = className;
        this.teacherName = teacherName;
        this.credit_hour = credit_hour;
        this.period = period;
        this.classTime = classTime;
        this.classroom = classroom;
        this.vacantSeats = vacantSeats;
        this.state = state;
    }

    @Override
    public String toString() {
        return "eduAllCourseTable{" +
                "courseId='" + courseId + '\'' +
                ", className='" + className + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", credit_hour=" + credit_hour +
                ", period=" + period +
                ", classTime='" + classTime + '\'' +
                ", classroom='" + classroom + '\'' +
                ", vacantSeats=" + vacantSeats +
                ", state='" + state + '\'' +
                '}';
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getCredit_hour() {
        return credit_hour;
    }

    public void setCredit_hour(int credit_hour) {
        this.credit_hour = credit_hour;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
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

    public int getVacantSeats() {
        return vacantSeats;
    }

    public void setVacantSeats(int vacantSeats) {
        this.vacantSeats = vacantSeats;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
