package com.itlzh.service.impl;

import com.itlzh.mapper.GradeDAO;
import com.itlzh.pojo.Grade;
import com.itlzh.pojo.GradeAvg;
import com.itlzh.pojo.GradeTable;
import com.itlzh.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceimpl implements GradeService {

    @Autowired
    GradeDAO dao;

    @Override
    public int addGrade(Grade grade) {
        return dao.addGrade(grade);
    }

    @Override
    public int deleteGrade(String studentId) {
        return dao.deleteGrade(studentId);
    }

    @Override
    public int updateGrade(Grade grade) {
        return dao.updateGrade(grade);
    }

    @Override
    public List<Grade> findAllGrade() {
        return dao.findAllGrade();
    }

    @Override
    public List<Grade> findOneGradeToId(String studentId) {
        return dao.findOneGradeToId(studentId);
    }

    @Override
    public List<Grade> findOneGradeToName(String studentName) {
        return dao.findOneGradeToName(studentName);
    }

    @Override
    public GradeAvg findAverageScores() {
        return dao.findAverageScores();
    }

    @Override
    public List<GradeTable> findAllGradeTable() {
        return dao.findAllGradeTable();
    }
}
