package com.itlzh.service.impl;

import com.itlzh.mapper.CourseDAO;
import com.itlzh.pojo.Course;
import com.itlzh.pojo.CourseTable;
import com.itlzh.pojo.Score;
import com.itlzh.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceimpl implements CourseService {

    @Autowired
    CourseDAO dao;

    @Override
    public List<Course> findAllCourse() {
        return dao.findAllCourse();
    }

    @Override
    public int addSelectCourse(String studentId, String courseId) {
        return dao.addSelectCourse(studentId, courseId);
    }

    @Override
    public String findStuIdByName(String name) {
        return dao.findStuIdByName(name);
    }

    @Override
    public Course findCourseByCId(String courseId) {
        return dao.findCourseByCId(courseId);
    }

    @Override
    public int findCourseCount(String studentId) {
        return dao.findCourseCount(studentId);
    }

    @Override
    public int updateCourseCount(String studentId) {
        return dao.updateCourseCount(studentId);
    }

    @Override
    public int updateVacantSeatsInt(String courseId) {
        return dao.updateVacantSeatsInt(courseId);
    }

    @Override
    public CourseTable findCourseTableByOneStudent(String studentId) {
        return dao.findCourseTableByOneStudent(studentId);
    }

    @Override
    public List<Score> findAllScoreByOneStudent(String studentId) {
        return dao.findAllScoreByOneStudent(studentId);
    }

    @Override
    public int updateCourseState(Course course) {
        return dao.updateCourseState(course);
    }

    @Override
    public int creditHourTotalBySid(String studentId) {
        List<Score> scoreList = dao.findAllScoreByOneStudent(studentId);
        int creditHourTotal = 0;
        for (Score score: scoreList) {
            creditHourTotal = creditHourTotal + score.getCredit_hour();
        }
        return creditHourTotal;
    }
}
