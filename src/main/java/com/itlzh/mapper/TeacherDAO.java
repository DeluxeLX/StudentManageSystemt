package com.itlzh.mapper;

import com.itlzh.pojo.Course;
import com.itlzh.pojo.Score;

import java.util.List;

public interface TeacherDAO {

    // 通过课程ID找课
    Course findCourseByCid(String courseId);

    // 查找本老师的所有课程
    List<Course> findCourseBySelf(String teacherId);

    // 查找本老师的上线课程
    List<Course> findIsSelectCourseByTid(String teacherId);

    // 教师课程申请
    int addTeaCourse(Course course);

    // 教师课程删除
    int deleteTeaCourse(String courseId);

    // 教师课程修改
    int updateTeaCourse(Course course);

    // 通过老师姓名找老师编号
    String findTidByTName(String teacherName);

    // 期末成绩输入批量插入
    int addAllStuScore(List<Score> scoreList);

}