package com.utils.pojoTable;

public class teaStudentTable {

    private String studentId;
    private String name;
    private String sex;
    private String departmentName;
    private String className;

    public teaStudentTable() {}

    public teaStudentTable(String studentId, String name, String sex, String departmentName, String className) {
        this.studentId = studentId;
        this.name = name;
        this.sex = sex;
        this.departmentName = departmentName;
        this.className = className;
    }

    @Override
    public String toString() {
        return "teaStudentTable{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", className='" + className + '\'' +
                '}';
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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
