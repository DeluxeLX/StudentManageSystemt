package com.itlzh.pojo;

import com.utils.Datetime.DateUtils;

import java.util.Date;

public class Punishment {
    private String id;
    private String studentId;   // 外键，学生ID，不能为空，（惩罚）一对多（学生ID）
    private int punishLevel;    // 外键，惩罚代号，可以为空，（惩罚）一对一（惩罚代号）
    private String punishLevelStr;
    private Date recTime;
    private String recTimeStr;
    private String enable;
    private String description;

    private Student oneStudent;
    private punishLevel punishLevelObj;

    public Punishment() {}

    public Punishment(String id, String studentId, int punishLevel, Date recTime, String enable, String description) {
        this.id = id;
        this.studentId = studentId;
        this.punishLevel = punishLevel;
        this.recTime = recTime;
        this.enable = enable;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Punishment{" +
                "id='" + id + '\'' +
                ", studentId='" + studentId + '\'' +
                ", punishLevel=" + punishLevel +
                ", punishLevelStr='" + punishLevelStr + '\'' +
                ", recTime=" + recTime +
                ", recTimeStr='" + recTimeStr + '\'' +
                ", enable='" + enable + '\'' +
                ", description='" + description + '\'' +
                ", oneStudent=" + oneStudent +
                ", punishLevelObj=" + punishLevelObj +
                '}';
    }

    public String StudentpunishmentToString() {
        return "Punishment{" +
                "id=" + id +
                ", studentId=" + oneStudent.getStudentId() +
                ", name=" + oneStudent.getName() +
                ", sex=" + oneStudent.getSex() +
                ", classId=" + oneStudent.getClassId() +
                ", departmentId=" + oneStudent.getDepartmentId() +
                ", punishLevel=" + punishLevelObj.getCode() +
                ", punishContent=" + punishLevelObj.getDescription() +
                ", recTime=" + this.getRecTimeStr() +
                ", description=" + description +
                "}";
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

    public int getPunishLevel() {
        return punishLevel;
    }

    public void setPunishLevel(int punishLevel) {
        this.punishLevel = punishLevel;
    }

    public String getPunishLevelStr() {
        return punishLevelStr;
    }

    public void setPunishLevelStr(String punishLevelStr) {
        this.punishLevelStr = punishLevelStr;
    }

    public Date getRecTime() {
        return recTime;
    }

    public void setRecTime(Date recTime) {
        this.recTime = recTime;
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

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Student getOneStudent() {
        return oneStudent;
    }

    public void setOneStudent(Student oneStudent) {
        this.oneStudent = oneStudent;
    }

    public punishLevel getPunishLevelObj() {
        return punishLevelObj;
    }

    public void setPunishLevelObj(punishLevel punishLevelObj) {
        this.punishLevelObj = punishLevelObj;
    }
}
