package com.itlzh.service.impl;

import com.itlzh.mapper.EducationDAO;
import com.itlzh.pojo.Course;
import com.itlzh.pojo.Score;
import com.itlzh.pojo.refuseReason;
import com.itlzh.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationServiceimpl implements EducationService {

    @Autowired
    EducationDAO educationDAO;

    @Override
    public List<Course> findCourseByApply() {
        return educationDAO.findCourseByApply();
    }

    @Override
    public int agreeApplication(String courseId) {
        return educationDAO.agreeApplication(courseId);
    }

    @Override
    public int addRefuseReason(refuseReason reason) {
        return educationDAO.addRefuseReason(reason);
    }

    @Override
    public List<Score> findScoreByCid(String courseId) {
        return educationDAO.findScoreByCid(courseId);
    }
}
