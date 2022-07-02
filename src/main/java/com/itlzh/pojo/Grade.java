package com.itlzh.pojo;

public class Grade {

    private String id;
    private String studentId;
    private Integer mathGrade;
    private Integer javaGrade;
    private Integer englishGrade;
    private Integer sportGrade;

    private Student student;

    public Grade() {}

    public Grade(String id, String studentId, Integer mathGrade, Integer javaGrade, Integer englishGrade, Integer sportGrade) {
        this.id = id;
        this.studentId = studentId;
        this.mathGrade = mathGrade;
        this.javaGrade = javaGrade;
        this.englishGrade = englishGrade;
        this.sportGrade = sportGrade;
    }

    public Grade(String id, String studentId, Integer mathGrade, Integer javaGrade, Integer englishGrade, Integer sportGrade, Student student) {
        this.id = id;
        this.studentId = studentId;
        this.mathGrade = mathGrade;
        this.javaGrade = javaGrade;
        this.englishGrade = englishGrade;
        this.sportGrade = sportGrade;
        this.student = student;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id='" + id + '\'' +
                ", studentId='" + studentId + '\'' +
                ", mathGrade=" + mathGrade +
                ", JavaGrade=" + javaGrade +
                ", EnglishGrade=" + englishGrade +
                ", sportGrade=" + sportGrade +
                ", student=" + student +
                '}';
    }

    public String StudentGradeToString() {
        return "Grade{" +
                "id=" + id +
                ", studentId=" + student.getStudentId() +
                ", studentName=" + student.getName() +
                ", mathGrade=" + mathGrade +
                ", JavaGrade=" + javaGrade +
                ", EnglishGrade=" + englishGrade +
                ", sportGrade=" + sportGrade +
                '}';
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

    public Integer getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(Integer mathGrade) {
        this.mathGrade = mathGrade;
    }

    public Integer getJavaGrade() {
        return javaGrade;
    }

    public void setJavaGrade(Integer javaGrade) {
        this.javaGrade = javaGrade;
    }

    public Integer getEnglishGrade() {
        return englishGrade;
    }

    public void setEnglishGrade(Integer englishGrade) {
        this.englishGrade = englishGrade;
    }

    public Integer getSportGrade() {
        return sportGrade;
    }

    public void setSportGrade(Integer sportGrade) {
        this.sportGrade = sportGrade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
