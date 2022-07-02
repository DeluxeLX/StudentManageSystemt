package com.itlzh.mapper;

import com.itlzh.pojo.Course;
import com.itlzh.pojo.CourseTable;
import com.itlzh.pojo.Score;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseDAO {

    // 查看所有课程
    List<Course> findAllCourse();

    // 通过课程ID找课
    Course findCourseByCId(String courseId);

    // 学生选课，一次只能选一门课。通过传来的课程号和学号确定谁选了哪门课
    int addSelectCourse(@Param("studentId") String studentId, @Param("courseId") String courseId);

    // 通过姓名找学号
    String findStuIdByName(String name);

    // 视图寻找学生选了几门课
    int findCourseCount(String studentId);

    // 选课成功后修改学生选课的课程
    int updateCourseCount(String studentId);

    // 选课成功后修改课程空闲座位数
    int updateVacantSeatsInt(String courseId);

    // 查询一个学生的所选的所有课程
    CourseTable findCourseTableByOneStudent(String studentId);

    // 查询一个学生的所选课程的成绩
    List<Score> findAllScoreByOneStudent(String studentId);

    // 改变课程的状态
    int updateCourseState(Course course);
}
