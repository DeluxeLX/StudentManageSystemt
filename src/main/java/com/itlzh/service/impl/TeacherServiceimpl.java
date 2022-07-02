package com.itlzh.service.impl;

import com.itlzh.mapper.CourseDAO;
import com.itlzh.mapper.TeacherDAO;
import com.itlzh.pojo.Course;
import com.itlzh.pojo.Score;
import com.itlzh.pojo.Student;
import com.itlzh.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceimpl implements TeacherService {

    @Autowired
    TeacherDAO teacherDAO;

    @Autowired
    CourseDAO courseDAO;

    @Override
    public Course findCourseByCid(String courseId) {
        return teacherDAO.findCourseByCid(courseId);
    }

    @Override
    public List<Course> findCourseBySelf(String teacherId) {
        return teacherDAO.findCourseBySelf(teacherId);
    }

    @Override
    public List<Course> findIsSelectCourseByTid(String teacherId) {
        return teacherDAO.findIsSelectCourseByTid(teacherId);
    }

    @Override
    public int addTeaCourse(Course course) {
        return teacherDAO.addTeaCourse(course);
    }

    @Override
    public int deleteTeaCourse(String courseId) {
        return teacherDAO.deleteTeaCourse(courseId);
    }

    @Override
    public int updateTeaCourse(Course course) {
        return teacherDAO.updateTeaCourse(course);
    }

    @Override
    public List<Student> findAllStuByCid(String courseId) {
        Course course = courseDAO.findCourseByCId(courseId);
        return course.getStudentList();
    }

    @Override
    public String findTidByTName(String teacherName) {
        return teacherDAO.findTidByTName(teacherName);
    }

    @Override
    public int addAllStuScore(List<Score> scoreList) {
        return teacherDAO.addAllStuScore(scoreList);
    }
}
