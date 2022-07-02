package com.itlzh.mapper;

import com.itlzh.pojo.Change;

import java.util.List;

public interface ChangeDAO {
    // 插入一个学籍变更
    int addChange(Change change);

    // 通过一个学生ID来查询他的学籍变更详细信息
    Change findOneChange(String studentId);

    // 通过一个学籍变更代号查询所有有过学籍变更的同学的基本资料
    List<Change> findAllChangeByLevel(int changeLevel);

    List<Change> findChangeByClass(String classId);

    // 查询计算机学院所有的学籍变更
    List<Change> findAllChange();

    // 修改一个学籍变更
    int updateChange(Change change);

    // 删除一个学籍变更
    int deleteChange(String studentId);
}
