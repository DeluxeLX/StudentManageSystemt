package com.itlzh.pojo;

import com.utils.Datetime.DateUtils;

import java.util.Date;

public class Reward {
    private String id;
    private String studentId; // 外键，学生ID，不能为空，（奖励）一对多（学生）
    private int rewardLevel;  // 外键，奖励代号，可以为空，（奖励）一对一（奖励代号）
    private String rewardLevelStr;
    private Date recTime;
    private String recTimeStr;
    private String description;

    private Student oneStudent;       // 一个学生对象
    private rewardLevel rewardlevel;  // 一个奖励代号对应一个奖励等级对象

    public Reward() {}

    public Reward(String id, String studentId, int rewordLevel, Date recTime, String description) {
        this.id = id;
        this.studentId = studentId;
        this.rewardLevel = rewordLevel;
        this.recTime = recTime;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "id='" + id + '\'' +
                ", studentId='" + studentId + '\'' +
                ", rewardLevel=" + rewardLevel +
                ", rewardLevelStr='" + rewardLevelStr + '\'' +
                ", recTime=" + recTime +
                ", recTimeStr='" + recTimeStr + '\'' +
                ", description='" + description + '\'' +
                ", oneStudent=" + oneStudent +
                ", rewardlevel=" + rewardlevel +
                '}';
    }

    public String StudentrewardToString() {
        return "Reward{" +
                "id=" + id +
                ", studentId=" + oneStudent.getStudentId() +
                ", name=" + oneStudent.getName() +
                ", sex=" + oneStudent.getSex() +
                ", classId=" + oneStudent.getClassId() +
                ", departmentId" + oneStudent.getDepartmentId() +
                ", rewardLevel" + rewardlevel.getCode() +
                ", rewardContent" + rewardlevel.getDescription() +
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

    public int getRewardLevel() {
        return rewardLevel;
    }

    public void setRewardLevel(int rewordLevel) {
        this.rewardLevel = rewordLevel;
    }

    public String getRewardLevelStr() {
        return rewardLevelStr;
    }

    public void setRewardLevelStr(String rewardLevelStr) {
        this.rewardLevelStr = rewardLevelStr;
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

    public rewardLevel getRewardlevel() {
        return rewardlevel;
    }

    public void setRewardlevel(rewardLevel rewardlevel) {
        this.rewardlevel = rewardlevel;
    }
}
