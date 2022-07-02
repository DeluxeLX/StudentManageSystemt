package com.itlzh.service.impl;

import com.itlzh.mapper.ChangeDAO;
import com.itlzh.pojo.Change;
import com.itlzh.service.ChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChangeServiceimpl implements ChangeService {

    @Autowired
    ChangeDAO dao;

    @Override
    public int addChange(Change change) {
        return dao.addChange(change);
    }

    @Override
    public Change findOneChange(String studentId) {
        return dao.findOneChange(studentId);
    }

    @Override
    public List<Change> findAllChangeByLevel(int changeLevel) {
        return dao.findAllChangeByLevel(changeLevel);
    }

    @Override
    public List<Change> findChangeByClass(String classId) {
        return dao.findChangeByClass(classId);
    }

    @Override
    public List<Change> findAllChange() {
        return dao.findAllChange();
    }

    @Override
    public int updateChange(Change change) {
        return dao.updateChange(change);
    }

    @Override
    public int deleteChange(String studentId) {
        return dao.deleteChange(studentId);
    }
}
