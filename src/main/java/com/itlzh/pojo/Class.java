package com.itlzh.pojo;

public class Class {
    private String id;
    private String name;
    private String monitorId;  // 外键，班长学号，可以为空，（班级）一对一（班长学号）

    public Class() {}

    public Class(String id, String name, String monitorId) {
        this.id = id;
        this.name = name;
        this.monitorId = monitorId;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", monitorId='" + monitorId + '\'' +
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

    public String getMonitorId() {
        return monitorId;
    }

    public void setMonitorId(String monitorId) {
        this.monitorId = monitorId;
    }
}
