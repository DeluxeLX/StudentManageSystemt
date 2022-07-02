package com.itlzh.service;

import com.itlzh.pojo.Student;

import java.util.List;

public interface StudentService {
    // 插入一个学生的信息
    int addStudent(Student student);

    // 通过一个学生ID来查询这个学生的基本信息
    Student findOneStudent(String studentId);

    // 查询学生基本信息
    List<Student> findAllStudent();

    // 查询每个班的同学
    List<Student> findStudentByClass(String departmentId, String classId);

    // 根据传来的学生ID修改学生的基本信息
    int updateStudent(Student student);

    // 删除一个学生的信息
    int deleteStudent(String studentId);
}
