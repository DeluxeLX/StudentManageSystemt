package com.itlzh.pojo;

public class refuseReason {

    private String courseId;
    private int state;
    private String stateStr;
    private String refuseReason;

    public refuseReason() {}

    public refuseReason(String courseId, int state, String refuseReason) {
        this.courseId = courseId;
        this.state = state;
        this.refuseReason = refuseReason;
    }

    @Override
    public String toString() {
        return "refuseReason{" +
                "courseId='" + courseId + '\'' +
                ", state=" + state +
                ", stateStr='" + stateStr + '\'' +
                ", refuseReason='" + refuseReason + '\'' +
                '}';
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateStr() {
        return stateStr;
    }

    public void setStateStr(String stateStr) {
        this.stateStr = stateStr;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }
}
