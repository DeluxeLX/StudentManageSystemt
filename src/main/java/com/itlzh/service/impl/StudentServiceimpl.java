package com.itlzh.service.impl;

import com.itlzh.mapper.StudentDAO;
import com.itlzh.pojo.Student;
import com.itlzh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceimpl implements StudentService {

    @Autowired
    StudentDAO dao;

    @Override
    public int addStudent(Student student) {
        return dao.addStudent(student);
    }

    @Override
    public Student findOneStudent(String studentId) {
        return dao.findOneStudent(studentId);
    }

    @Override
    public List<Student> findAllStudent() {
        return dao.findAllStudent();
    }

    @Override
    public List<Student> findStudentByClass(String departmentId, String classId) {
        return dao.findStudentByClass(departmentId, classId);
    }

    @Override
    public int updateStudent(Student student) {
        return dao.updateStudent(student);
    }

    @Override
    public int deleteStudent(String studentId) {
        return dao.deleteStudent(studentId);
    }
}
