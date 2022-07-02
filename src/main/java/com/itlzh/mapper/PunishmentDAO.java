package com.itlzh.mapper;

import com.itlzh.pojo.Punishment;

import java.util.List;

public interface PunishmentDAO {
    // 插入一个学生的惩罚情况
    int addPunishment(Punishment punishment);

    // 通过一个学生ID查询它的惩罚情况
    Punishment findOnePunishment(String studentId);

    // 通过一个惩罚代号查询所有得了这个惩罚的学生
    List<Punishment> findAllPunishmentByLevel(int punishLevel);

    List<Punishment> findPunishmentByClass(String classId);

    List<Punishment> findAllPunishment();

    int updatePunishment(Punishment punishment);

    int deletePunishment(String studentId);
}
