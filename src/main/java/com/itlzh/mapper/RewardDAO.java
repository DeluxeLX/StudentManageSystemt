package com.itlzh.mapper;

import com.itlzh.pojo.Reward;

import java.util.List;

public interface RewardDAO {
    // 插入一个学生奖励情况
    int addReward(Reward reward);

    // 通过一个学生ID查询它的奖励情况
    Reward findOneReward(String studentId);

    // 通过一个奖励代号查询所有得了这个奖励的学生
    List<Reward> findAllRewardByLevel(int rewardLevel);

    List<Reward> findRewardByClass(String classId);

    List<Reward> findAllReward();

    int updateReward(Reward reward);

    int deleteReward(String studentId);
}
