package com.itlzh.pojo;

public class courseState {
    private int courseCode;
    private String description;

    public courseState() {}

    public courseState(int courseCode, String description) {
        this.courseCode = courseCode;
        this.description = description;
    }

    @Override
    public String toString() {
        return "courseState{" +
                "courseCode=" + courseCode +
                ", description='" + description + '\'' +
                '}';
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
