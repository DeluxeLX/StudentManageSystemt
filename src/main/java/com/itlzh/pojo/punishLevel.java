package com.itlzh.pojo;

public class punishLevel {
    private int code;
    private String description;

    public punishLevel() {}

    public punishLevel(int code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String toString() {
        return "punishLevel{" +
                "code=" + code +
                ", description='" + description + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
