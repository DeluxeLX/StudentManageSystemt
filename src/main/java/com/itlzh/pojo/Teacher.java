package com.itlzh.pojo;

import java.util.List;

public class Teacher {

    private String id;
    private String name;
    private String departmentId;
    private List<Course> courseList;  // 老师和课程，一对多，一个老师可以上多门课，一门课只有一个老师

    public Teacher() {}

    public Teacher(String id, String name, String departmentId) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", departmentId='" + departmentId + '\'' +
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

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
