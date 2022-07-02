package com.itlzh.pojo;

public class GradeTable {

    private String studentId;
    private String studentName;
    private int mathGrade;
    private int javaGrade;
    private int englishGrade;
    private int sportGrade;
    private int allGrade;

    public GradeTable() {}

    public GradeTable(String studentId, String studentName, int mathGrade, int javaGrade, int englishGrade, int sportGrade, int allGrade) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.mathGrade = mathGrade;
        this.javaGrade = javaGrade;
        this.englishGrade = englishGrade;
        this.sportGrade = sportGrade;
        this.allGrade = allGrade;
    }

    @Override
    public String toString() {
        return "GradeTable{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", mathGrade=" + mathGrade +
                ", javaGrade=" + javaGrade +
                ", englishGrade=" + englishGrade +
                ", sportGrade=" + sportGrade +
                ", allGrade=" + allGrade +
                '}';
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(int mathGrade) {
        this.mathGrade = mathGrade;
    }

    public int getJavaGrade() {
        return javaGrade;
    }

    public void setJavaGrade(int javaGrade) {
        this.javaGrade = javaGrade;
    }

    public int getEnglishGrade() {
        return englishGrade;
    }

    public void setEnglishGrade(int englishGrade) {
        this.englishGrade = englishGrade;
    }

    public int getSportGrade() {
        return sportGrade;
    }

    public void setSportGrade(int sportGrade) {
        this.sportGrade = sportGrade;
    }

    public int getAllGrade() {
        return allGrade;
    }

    public void setAllGrade(int allGrade) {

        this.allGrade = allGrade;
    }
}
