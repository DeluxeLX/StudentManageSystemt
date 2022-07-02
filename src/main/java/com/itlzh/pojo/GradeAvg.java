package com.itlzh.pojo;

public class GradeAvg {

    private double mathAvgGrade;
    private double javaAvgGrade;
    private double englishAvgGrade;
    private double sportAvgGrade;
    private double allAvgGrade;

    public GradeAvg() {}

    public GradeAvg(double mathAvgGrade, double javaAvgGrade, double englishAvgGrade, double sportAvgGrade, double allAvgGrade) {
        this.mathAvgGrade = mathAvgGrade;
        this.javaAvgGrade = javaAvgGrade;
        this.englishAvgGrade = englishAvgGrade;
        this.sportAvgGrade = sportAvgGrade;
        this.allAvgGrade = allAvgGrade;
    }

    @Override
    public String toString() {
        return "GradeAvg{" +
                "mathAvgGrade=" + mathAvgGrade +
                ", javaAvgGrade=" + javaAvgGrade +
                ", englishAvgGrade=" + englishAvgGrade +
                ", sportAvgGrade=" + sportAvgGrade +
                ", allAvgGrade=" + allAvgGrade +
                '}';
    }

    public double getMathAvgGrade() {
        return mathAvgGrade;
    }

    public void setMathAvgGrade(double mathAvgGrade) {
        this.mathAvgGrade = mathAvgGrade;
    }

    public double getJavaAvgGrade() {
        return javaAvgGrade;
    }

    public void setJavaAvgGrade(double javaAvgGrade) {
        this.javaAvgGrade = javaAvgGrade;
    }

    public double getEnglishAvgGrade() {
        return englishAvgGrade;
    }

    public void setEnglishAvgGrade(double englishAvgGrade) {
        this.englishAvgGrade = englishAvgGrade;
    }

    public double getSportAvgGrade() {
        return sportAvgGrade;
    }

    public void setSportAvgGrade(double sportAvgGrade) {
        this.sportAvgGrade = sportAvgGrade;
    }

    public double getAllAvgGrade() {
        return allAvgGrade;
    }

    public void setAllAvgGrade(double allAvgGrade) {
        this.allAvgGrade = allAvgGrade;
    }
}
