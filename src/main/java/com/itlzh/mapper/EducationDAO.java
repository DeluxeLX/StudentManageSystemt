package com.itlzh.mapper;

import com.itlzh.pojo.Course;
import com.itlzh.pojo.Score;
import com.itlzh.pojo.refuseReason;

import java.util.List;

public interface EducationDAO {

    // 查看所有申请，state=0&=1&=2
    List<Course> findCourseByApply();

    // 同意申请，state=4
    int agreeApplication(String courseId);

    // 插入拒绝申请
    int addRefuseReason(refuseReason reason);

    // 查找一个班上所有同学的成绩
    List<Score> findScoreByCid(String courseId);
}
