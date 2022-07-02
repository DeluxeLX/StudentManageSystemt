package com.itlzh.service;

import com.itlzh.pojo.Grade;
import com.itlzh.pojo.GradeAvg;
import com.itlzh.pojo.GradeTable;

import java.util.List;

public interface GradeService {
    // 添加学生成绩功能
    int addGrade(Grade grade);

    // 删除学生成绩功能
    int deleteGrade(String studentId);

    // 编辑学生成绩功能
    int updateGrade(Grade grade);

    // 查询全部学生成绩功能
    List<Grade> findAllGrade();

    // 根据学生学号查找学生成绩功能
    List<Grade> findOneGradeToId(String studentId);

    // 根据学生姓名（支持模糊匹配）查找学生成绩功能
    List<Grade> findOneGradeToName(String studentName);

    // 计算每个成绩的班级平均成绩
    GradeAvg findAverageScores();

    // 设置一个专门用作表格的类
    List<GradeTable> findAllGradeTable();
}
