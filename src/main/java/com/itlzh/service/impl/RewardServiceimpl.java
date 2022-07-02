package com.itlzh.service.impl;

import com.itlzh.mapper.RewardDAO;
import com.itlzh.pojo.Reward;
import com.itlzh.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardServiceimpl implements RewardService {

    @Autowired
    RewardDAO dao;

    @Override
    public int addReward(Reward reward) {
        return dao.addReward(reward);
    }

    @Override
    public Reward findOneReward(String studentId) {
        return dao.findOneReward(studentId);
    }

    @Override
    public List<Reward> findAllRewardByLevel(int rewardLevel) {
        return dao.findAllRewardByLevel(rewardLevel);
    }

    @Override
    public List<Reward> findRewardByClass(String classId) {
        return dao.findRewardByClass(classId);
    }

    @Override
    public List<Reward> findAllReward() {
        return dao.findAllReward();
    }

    @Override
    public int updateReward(Reward reward) {
        return dao.updateReward(reward);
    }

    @Override
    public int deleteReward(String studentId) {
        return dao.deleteReward(studentId);
    }
}
