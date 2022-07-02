package com.itlzh.controller;

import com.itlzh.pojo.Reward;
import com.itlzh.service.RewardService;
import com.utils.transformationID.IDTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/reward")
public class RewardController {

    @Autowired
    RewardService rewardService;

    @RequestMapping(value = "/findAllReward.do")
    public ModelAndView findAllReward() {
        ModelAndView mav = new ModelAndView();
        List<Reward> rewardList = rewardService.findAllReward();
        IDTransClassAndDep(rewardList);
        if (rewardList.size() == 0) {
            mav.addObject("checkResult", "未查询到相关信息...");
        }
        mav.addObject("studentRewardList", rewardList);
        mav.setViewName("studentRewardList");
        return mav;
    }

    @RequestMapping(value = "/addReward.do")
    public String addReward(Reward reward) {
        String checkResult = null;
        Date date = new Date();
        int rewardLevel = IDTransformation.rewardStr2rewardLevel(reward.getRewardLevelStr());
        reward.setRewardLevel(rewardLevel);
        reward.setRecTime(date);

        System.out.println(reward);

        System.out.println("进入到了addReward.do...");
        int count = rewardService.addReward(reward);
        System.out.println(count);

        return "redirect:findAllReward.do";
    }

    @RequestMapping(value = "/updateRewardPage.do")
    public ModelAndView updateRewardPage(String studentId) {
        ModelAndView mav = new ModelAndView();
        Reward reward = rewardService.findOneReward(studentId);
        System.out.println(reward);

        mav.addObject("studentReward", reward);
        mav.setViewName("rewardUpdate");
        return mav;
    }

    @RequestMapping(value = "/updateReward.do")
    public String updateReward(Reward reward) {

        System.out.println("进入到了updateReward.do...中");
        System.out.println(reward);
        int rewardLevel = IDTransformation.rewardStr2rewardLevel(reward.getRewardLevelStr());
        reward.setRewardLevel(rewardLevel);
        reward.setRecTime(new Date());
        int count = rewardService.updateReward(reward);
        System.out.println(count);

        return "redirect:findAllReward.do";
    }

    @RequestMapping(value = "/deleteReward.do")
    public String deleteReward(String studentId) {
        int count = rewardService.deleteReward(studentId);
        System.out.println(count);
        return "redirect:findAllReward.do";
    }

    @RequestMapping(value = "/findRewardByClass.do")
    public ModelAndView findRewardByClass(String className) {
        ModelAndView mav = new ModelAndView();

        String classId = IDTransformation.className2classId(className);
        List<Reward> rewardList = rewardService.findRewardByClass(classId);
        IDTransClassAndDep(rewardList);

        mav.addObject("studentRewardList", rewardList);
        mav.setViewName("studentRewardList");
        return mav;
    }

    @RequestMapping(value = "/findRewardByLevel.do")
    public ModelAndView findRewardByLevel(String rewardLevelStr) {
        ModelAndView mav = new ModelAndView();

        int rewardLevel = IDTransformation.rewardStr2rewardLevel(rewardLevelStr);
        List<Reward> rewardList = rewardService.findAllRewardByLevel(rewardLevel);
        IDTransClassAndDep(rewardList);

        mav.addObject("studentRewardList", rewardList);
        mav.setViewName("studentRewardList");
        return mav;
    }

    private void IDTransClassAndDep(List<Reward> rewardList) {
        for (Reward reward: rewardList) {
            String classId1 = reward.getOneStudent().getClassId();
            String departmentId = reward.getOneStudent().getDepartmentId();
            String className = IDTransformation.classId2className(classId1);
            String departmentName = IDTransformation.departmentId2departmentName(departmentId);
            reward.getOneStudent().setClassId(className);
            reward.getOneStudent().setDepartmentId(departmentName);
        }
    }
}
