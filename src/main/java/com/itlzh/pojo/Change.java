package com.itlzh.pojo;

import com.utils.Datetime.DateUtils;

import java.util.Date;

public class Change {
    private String id;
    private String studentId;   // 外键，学生ID，不能为空，（学籍更改）一对多（学生ID）
    private int changeLevel;    // 外键，学籍更改代号，可以为空，（学籍更改）一对一（学籍更改代号）
    private String changeLevelStr;
    private Date recTime;
    private String recTimeStr;  // 日期字符串版本，容易输出一点
    private String description;

    private Student oneStudent;            // 一个学生对象
    // private List<Student> allStudent;   // 存在这个学籍更改的所有学生
    private changeCode changecode;         // 一个学生学籍更改代号对应的一个学籍更改代码

    public Change() {}

    public Change(String id, String studentId, int changeLevel, Date recTime, String description) {
        this.id = id;
        this.studentId = studentId;
        this.changeLevel = changeLevel;
        this.recTime = recTime;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Change{" +
                "id='" + id + '\'' +
                ", studentId='" + studentId + '\'' +
                ", changeLevel=" + changeLevel +
                ", changeLevelStr='" + changeLevelStr + '\'' +
                ", recTime=" + recTime +
                ", recTimeStr='" + recTimeStr + '\'' +
                ", description='" + description + '\'' +
                ", oneStudent=" + oneStudent +
                ", changecode=" + changecode +
                '}';
    }

    public String OneStudentchangeToString() {
        return  "Change{" +
                "id=" + id +
                ", studentId=" + oneStudent.getStudentId() +
                ", studentName=" + oneStudent.getName() +
                ", changeLevel=" + changecode.getCode() +
                ", changeContent=" + changecode.getDescription() +
                ", recTime=" + this.getRecTimeStr() +
                ", description=" + description +
                "}";
    }

    public String AllStudentchangeToString() {
        return "Student{" +
                "id=" + id +
                ", studentId=" + oneStudent.getStudentId() +
                ", name=" + oneStudent.getName() +
                ", sex=" + oneStudent.getSex() +
                ", classId=" + oneStudent.getClassId() +
                ", department=" + oneStudent.getDepartmentId() +
                ", birthday=" + oneStudent.getBirthdayStr() +
                ", nativePlace=" + oneStudent.getNativePlace() +
                ", changeContent=" + changecode.getDescription() +
                ", recTime=" + this.getRecTimeStr() +
                ", description=" + description +
                "}";
    }

    public Student getOneStudent() {
        return oneStudent;
    }

    public void setOneStudent(Student oneStudent) {
        this.oneStudent = oneStudent;
    }

    public changeCode getChangecode() {
        return changecode;
    }

    public void setChangecode(changeCode changecode) {
        this.changecode = changecode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getChangeLevel() {
        return changeLevel;
    }

    public void setChangeLevel(int changeLevel) {
        this.changeLevel = changeLevel;
    }

    public Date getRecTime() {
        return recTime;
    }

    public void setRecTime(Date recTime) {
        this.recTime = recTime;
    }

    public String getChangeLevelStr() {
        return changeLevelStr;
    }

    public void setChangeLevelStr(String changeLevelStr) {
        this.changeLevelStr = changeLevelStr;
    }

    public String getRecTimeStr() {
        if (recTime != null) {
            recTimeStr = DateUtils.date2String(recTime, "yyyy/MM/dd");
        }
        return recTimeStr;
    }

    public void setRecTimeStr(String recTimeStr) {
        this.recTimeStr = recTimeStr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
