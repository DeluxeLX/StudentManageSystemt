package com.itlzh.pojo;

import com.utils.Datetime.DateUtils;

import java.util.Date;

public class Student {
    private String studentId;
    private String name;
    private String sex;
    private String classId;       // 外键，班级ID，可以为空，（学生）多对一（班级）
    private String departmentId;  // 外键，院系ID，可以为空，（学生）多对一（院系）
    private Date birthday;
    private String birthdayStr;
    private String nativePlace;

    private Class aclass;
    private Department department;

    private Integer score;

    public Student() {}

    public Student(String studentId, String name, String sex, String classId, String departmentId, Date birthday, String nativePlace) {
        this.studentId = studentId;
        this.name = name;
        this.sex = sex;
        this.classId = classId;
        this.departmentId = departmentId;
        this.birthday = birthday;
        this.nativePlace = nativePlace;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", classId='" + classId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", birthday=" + this.getBirthdayStr() +
                ", nativePlace='" + nativePlace + '\'' +
                ", aclass=" + aclass +
                ", department=" + department +
                '}';
    }

    public Class getAclass() {
        return aclass;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setAclass(Class aclass) {
        this.aclass = aclass;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBirthdayStr() {
        if (birthday != null) {
            birthdayStr = DateUtils.date2String(birthday, "yyyy/MM/dd");
        }
        return birthdayStr;
    }

    public void setBirthdayStr(String birthdayStr) {
        this.birthdayStr = birthdayStr;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }
}
