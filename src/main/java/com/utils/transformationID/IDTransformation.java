package com.utils.transformationID;

public class IDTransformation {

    // class名字转换成ID
    public static String className2classId(String className) {
        String classId = null;
        if (className.equalsIgnoreCase("计算机科学与技术")) {
            classId = "01";
        } else if (className.equalsIgnoreCase("人工智能")) {
            classId = "02";
        } else if (className.equalsIgnoreCase("信息安全")) {
            classId = "03";
        } else if (className.equalsIgnoreCase("物联网工程")) {
            classId = "04";
        } else if (className.equalsIgnoreCase("软件工程")) {
            classId = "05";
        } else if (className.equalsIgnoreCase("数据科学与大数据技术")) {
            classId = "06";
        }
        return classId;
    }

    // classId转换成班级名字
    public static String classId2className(String classId) {
        String className = null;
        if (classId.equalsIgnoreCase("01")) {
            className = "计算机科学与技术";
        } else if (classId.equalsIgnoreCase("02")) {
            className = "人工智能";
        } else if (classId.equalsIgnoreCase("03")) {
            className = "信息安全";
        } else if (classId.equalsIgnoreCase("04")) {
            className= "物联网工程";
        } else if (classId.equalsIgnoreCase("05")) {
            className = "软件工程";
        } else if (classId.equalsIgnoreCase("06")) {
            className = "数据科学与大数据技术";
        }
        return className;
    }

    // department名字转换成Id
    public static String departmentName2departmentId(String departmentName) {
        String departmentId = null;
        if (departmentName.equalsIgnoreCase("机械电子工程学院")) {
            departmentId = "202201";
        } else if (departmentName.equalsIgnoreCase("生物科学学院")) {
            departmentId = "202202";
        } else if (departmentName.equalsIgnoreCase("化学与化工学院")) {
            departmentId = "202203";
        } else if (departmentName.equalsIgnoreCase("商学院")) {
            departmentId = "202204";
        } else if (departmentName.equalsIgnoreCase("马克思主义学院")) {
            departmentId = "202205";
        } else if (departmentName.equalsIgnoreCase("计算机科学与工程学院")) {
            departmentId = "202206";
        } else if (departmentName.equalsIgnoreCase("外国语学院")) {
            departmentId = "202207";
        } else if (departmentName.equalsIgnoreCase("艺术学院")) {
            departmentId = "202208";
        } else if (departmentName.equalsIgnoreCase("人文学院")) {
            departmentId = "202209";
        } else if (departmentName.equalsIgnoreCase("数学与计算科学学院")) {
            departmentId = "202210";
        } else if (departmentName.equalsIgnoreCase("体育学院")) {
            departmentId = "202211";
        } else if (departmentName.equalsIgnoreCase("资源环境与安全工程学院")) {
            departmentId = "202212";
        }
        return departmentId;
    }

    // departmentId转换成名字
    public static String departmentId2departmentName(String departmentId) {
        String departmentName = null;
        if (departmentId.equalsIgnoreCase("202201")) {
            departmentName = "机械电子工程学院";
        } else if (departmentId.equalsIgnoreCase("202202")) {
            departmentName = "生物科学学院";
        } else if (departmentId.equalsIgnoreCase("202203")) {
            departmentName = "化学与化工学院";
        } else if (departmentId.equalsIgnoreCase("202204")) {
            departmentName = "商学院";
        } else if (departmentId.equalsIgnoreCase("202205")) {
            departmentName = "马克思主义学院";
        } else if (departmentId.equalsIgnoreCase("202206")) {
            departmentName = "计算机科学与工程学院";
        } else if (departmentId.equalsIgnoreCase("202207")) {
            departmentName = "外国语学院";
        } else if (departmentId.equalsIgnoreCase("202208")) {
            departmentName = "艺术学院";
        } else if (departmentId.equalsIgnoreCase("202209")) {
            departmentName = "人文学院";
        } else if (departmentId.equalsIgnoreCase("202210")) {
            departmentName = "数学与计算科学学院";
        } else if (departmentId.equalsIgnoreCase("202211")) {
            departmentName = "体育学院";
        } else if (departmentId.equalsIgnoreCase("202212")) {
            departmentName = "资源环境与安全工程学院";
        }
        return departmentName;
    }

    // change名字改成changeId
    public static int changeStr2changeLevel(String changeStr) {
        int changeLevel;
        if (changeStr.equalsIgnoreCase("休学")) {
            changeLevel = 1;
        } else if (changeStr.equalsIgnoreCase("复学")) {
            changeLevel = 2;
        } else if (changeStr.equalsIgnoreCase("退学")) {
            changeLevel = 3;
        } else if (changeStr.equalsIgnoreCase("毕业")) {
            changeLevel = 4;
        } else {
            changeLevel = 0;
        }
        return changeLevel;
    }

    // changeId转换成change名字
    public static String changeLevel2changeStr(int changeLevel) {
        String changeStr = null;
        if (changeLevel == 0) {
            changeStr = "转系";
        } else if (changeLevel == 1) {
            changeStr = "休学";
        } else if (changeLevel == 2) {
            changeStr = "复学";
        } else if (changeLevel == 3) {
            changeStr = "退学";
        } else {
            changeStr = "毕业";
        }
        return changeStr;
    }

    public static int rewardStr2rewardLevel(String rewardStr) {
        int changeLevel;
        if (rewardStr.equalsIgnoreCase("校一等奖学金")) {
            changeLevel = 1;
        } else if (rewardStr.equalsIgnoreCase("校二等奖学金")) {
            changeLevel = 2;
        } else if (rewardStr.equalsIgnoreCase("校三等奖学金")) {
            changeLevel = 3;
        } else if (rewardStr.equalsIgnoreCase("系一等奖学金")) {
            changeLevel = 4;
        } else if (rewardStr.equalsIgnoreCase("系二等奖学金")) {
            changeLevel = 5;
        } else if (rewardStr.equalsIgnoreCase("系三等奖学金")) {
            changeLevel = 6;
        } else {
            changeLevel = 0;
        }
        return changeLevel;
    }

    public static String rewardLevel2rewardStr(int rewardLevel) {
        String changeStr = null;
        if (rewardLevel == 0) {
            changeStr = "校特等奖学金";
        } else if (rewardLevel == 1) {
            changeStr = "校一等奖学金";
        } else if (rewardLevel == 2) {
            changeStr = "校二等奖学金";
        } else if (rewardLevel == 3) {
            changeStr = "校三等奖学金";
        } else if (rewardLevel == 4) {
            changeStr = "系一等奖学金";
        } else if (rewardLevel == 5) {
            changeStr = "系二等奖学金";
        } else if (rewardLevel == 6) {
            changeStr = "系三等奖学金";
        }
        return changeStr;
    }

    public static int punishmentStr2punishmentLevel(String punishmentStr) {
        int punishmentLevel = -1;
        if (punishmentStr.equalsIgnoreCase("警告")) {
            punishmentLevel = 0;
        } else if (punishmentStr.equalsIgnoreCase("严重警告")) {
            punishmentLevel = 1;
        } else if (punishmentStr.equalsIgnoreCase("记过")) {
            punishmentLevel = 2;
        } else if (punishmentStr.equalsIgnoreCase("记大过")) {
            punishmentLevel = 3;
        } else if (punishmentStr.equalsIgnoreCase("开除")) {
            punishmentLevel = 4;
        }
        return punishmentLevel;
    }

    public static String enableTF2enableStr(String enableTF) {
        String enableStr;
        if (enableTF.equalsIgnoreCase("T")) {
            enableStr = "是";
        } else {
            enableStr = "否";
        }
        return enableStr;
    }

    public static String courseName2JspStr(String courseName) {
        String courseNameStr;
        String week = null;
        String time = courseName.substring(2, 3) + courseName.charAt(4);
        String weekRel = courseName.substring(0, 2);
        if (weekRel.equalsIgnoreCase("周一")) {
            week = "Mon";
        } else if (weekRel.equalsIgnoreCase("周二")) {
            week = "Tue";
        } else if (weekRel.equalsIgnoreCase("周三")) {
            week = "Wed";
        } else if (weekRel.equalsIgnoreCase("周四")) {
            week = "Thu";
        } else if (weekRel.equalsIgnoreCase("周五")) {
            week = "Fri";
        } else if (weekRel.equalsIgnoreCase("周六")) {
            week = "Sat";
        } else if (weekRel.equalsIgnoreCase("周日")) {
            week = "Sun";
        }

        courseNameStr = week + time;
        return courseNameStr;
    }

    public static int courseStateStr2State(String stateStr) {
        int state=-1;
        if (stateStr.equalsIgnoreCase("申请增加新课程")) {
            state = 0;
        } else if (stateStr.equalsIgnoreCase("申请删除新课程")) {
            state = 1;
        } else if (stateStr.equalsIgnoreCase("申请修改新课程")) {
            state = 2;
        } else if (stateStr.equalsIgnoreCase("可选（激活）")) {
            state = 3;
        } else if (stateStr.equalsIgnoreCase("等待课程安排")) {
            state = 4;
        } else if (stateStr.equalsIgnoreCase("已删除")) {
            state = 5;
        } else if (stateStr.equalsIgnoreCase("拒绝申请")) {
            state = 6;
        }
        return state;
    }
}
