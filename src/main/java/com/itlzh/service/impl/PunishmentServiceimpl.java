package com.itlzh.service.impl;

import com.itlzh.mapper.PunishmentDAO;
import com.itlzh.pojo.Punishment;
import com.itlzh.service.PunishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PunishmentServiceimpl implements PunishmentService {

    @Autowired
    PunishmentDAO dao;

    @Override
    public int addPunishment(Punishment punishment) {
        return dao.addPunishment(punishment);
    }

    @Override
    public Punishment findOnePunishment(String studentId) {
        return dao.findOnePunishment(studentId);
    }

    @Override
    public List<Punishment> findAllPunishmentByLevel(int punishLevel) {
        return dao.findAllPunishmentByLevel(punishLevel);
    }

    @Override
    public List<Punishment> findPunishmentByClass(String classId) {
        return dao.findPunishmentByClass(classId);
    }

    @Override
    public List<Punishment> findAllPunishment() {
        return dao.findAllPunishment();
    }

    @Override
    public int updatePunishment(Punishment punishment) {
        return dao.updatePunishment(punishment);
    }

    @Override
    public int deletePunishment(String studentId) {
        return dao.deletePunishment(studentId);
    }
}
