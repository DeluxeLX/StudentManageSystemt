package com.itlzh.pojo;

public class Score {

    private String studentId;
    private String studentName;
    private String courseName;
    private Integer credit_hour;
    private Integer score;
    private String scoreStr;

    public Score() {}

    public Score(String studentId, String courseName, Integer credit_hour, Integer score) {
        this.studentId = studentId;
        this.courseName = courseName;
        this.credit_hour = credit_hour;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credit_hour=" + credit_hour +
                ", score=" + score +
                ", scoreStr='" + scoreStr + '\'' +
                '}';
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCredit_hour() {
        return credit_hour;
    }

    public void setCredit_hour(Integer credit_hour) {
        this.credit_hour = credit_hour;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }


    public String getScoreStr() {
        if (score == null) {
            scoreStr = "未考试";
        } else {
            scoreStr = score.toString();
        }
        return scoreStr;
    }

    public void setScoreStr(String scoreStr) {
        this.scoreStr = scoreStr;
    }
}
