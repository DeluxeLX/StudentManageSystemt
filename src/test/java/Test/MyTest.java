package Test;

import cn.hutool.json.JSONArray;
import com.itlzh.pojo.*;
import com.itlzh.service.*;
import com.utils.transformationID.IDTransformation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)   // 启动spring容器
@ContextConfiguration(locations = {"classpath:conf/applicationContext_mapper.xml", "classpath:conf/applicationContext_service.xml"})
public class MyTest {

    Date date = new Date();

    @Autowired
    StudentService studentService;

    @Autowired
    ChangeService changeService;

    @Autowired
    RewardService rewardService;

    @Autowired
    PunishmentService punishmentService;

    @Autowired
    GradeService gradeService;

    @Autowired
    UserService userService;

    @Autowired
    CourseService courseService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    EducationService educationService;

    /**
     * 学生模块功能测试
     */
    @Test
    public void addStudent() {
        Student stu = new Student("2005040239", "王大柱", "男", "04", "202206", date, "宁夏");
        int count = studentService.addStudent(stu);
        System.out.println(count);
    }

    @Test
    public void findOneStudent() {
        Student stu = studentService.findOneStudent("2005040236");
        System.out.println(stu);
    }

    @Test
    public void findAllStudent() {
        List<Student> list = studentService.findAllStudent();
        for (Student stu : list) {
            System.out.println(stu);
        }
    }

    @Test
    public void updateStudent() {
        Student stu = new Student("2005040236", "白龙马", "男", "03", "202205", date, "东海");
        int count = studentService.updateStudent(stu);
        System.out.println(count);
    }

    @Test
    public void deleteStudent() {
        int count = studentService.deleteStudent("2005040239");
        System.out.println(count);
    }

    @Test
    public void findStudentByClass() {
        List<Student> studentList = studentService.findStudentByClass("202206", "02");
        for (Student stu: studentList) {
            System.out.println(stu);
        }
    }
    /**
     * 学籍变更功能测试
     */
    @Test
    public void addChange() {
        Change change = new Change("0", "2005040236", 0, date, "转系了，转系了");
        int count = changeService.addChange(change);
        System.out.println(count);
    }

    @Test
    public void findOneChange() {
        Change change1 = changeService.findOneChange("2005040201");
        Change change2 = changeService.findOneChange("2005040206");
        System.out.println(change1.OneStudentchangeToString());
        System.out.println(change1);
        System.out.println(change2.OneStudentchangeToString());
        System.out.println(change2);
    }

    @Test
    public void findAllChangeByLevel() {
        List<Change> list = changeService.findAllChangeByLevel(4);
        for (Change change: list) {
            System.out.println(change.AllStudentchangeToString());
        }
    }

    @Test
    public void findAllChange() {
        List<Change> list = changeService.findAllChange();
        for (Change change: list) {
            System.out.println(change);
        }
    }

    @Test
    public void updateChange() {
        Change change = new Change("0", "2005040236", 1, date, "我先休学啦");
        int count = changeService.updateChange(change);
        System.out.println(count);
    }

    /**
     * 奖励功能测试
     */
    @Test
    public void addReward() {
        Reward reward = new Reward("0", "2005040201", 3, date, "该生成绩还行，就是有点丑");
        Reward reward1 = new Reward("1", "2005040205", 4, date, "平平YYDS！");
        Reward reward2 = new Reward("2", "2005040206", 2, date, "再接再厉呀！");
        Reward reward3 = new Reward("3", "2005040212", 4, date, "不挂科高多了");
        Reward reward4 = new Reward("4", "2005040224", 3, date, "政策原因");
        Reward reward5 = new Reward("5", "2005040227", 3, date, "加油过四级呀");
        // int count = rewardService.addReward(reward);
        int count1 = rewardService.addReward(reward1);
        int count2 = rewardService.addReward(reward2);
        int count3 = rewardService.addReward(reward3);
        int count4 = rewardService.addReward(reward4);
        int count5 = rewardService.addReward(reward5);
        System.out.println(count1+count2+count3+count4+count5);
    }

    @Test
    public void findOndReward() {
        Reward reward1 = rewardService.findOneReward("2005040201");
        System.out.println(reward1.StudentrewardToString());
    }

    @Test
    public void findAllReward() {
        List<Reward> list = rewardService.findAllRewardByLevel(3);
        for (Reward reward: list) {
            System.out.println(reward.StudentrewardToString());
        }
    }

    @Test
    public void updateReward() {
        Reward reward = new Reward("0", "2005040236", 2, date, "二等奖学金哈哈哈");
        int count = rewardService.updateReward(reward);
        System.out.println(count);
    }

    /**
     * 惩罚情况测试
     */
    @Test
    public void addPunishment() {
        //Punishment punishment = new Punishment("0", "2005040205", 1, date, "F", "纯属捏造，别当真呀兄弟们！");
        Punishment punishment1 = new Punishment("0", "2005040212", 1, date, "F", "纯属捏造，别当真呀兄弟们！");
        Punishment punishment2 = new Punishment("0", "2005040224", 3, date, "T", "纯属捏造，别当真呀兄弟们！");
        Punishment punishment3 = new Punishment("0", "2005040227", 1, date, "T", "纯属捏造，别当真呀兄弟们！");
        //int count1 = punishmentService.addPunishment(punishment);
        punishmentService.addPunishment(punishment1);
        punishmentService.addPunishment(punishment2);
        punishmentService.addPunishment(punishment3);
        //System.out.println(count1);
    }

    @Test
    public void findOnePunishment() {
        Punishment punishment = punishmentService.findOnePunishment("2005040206");
        Punishment punishment1 = punishmentService.findOnePunishment("2005040227");
        System.out.println(punishment.StudentpunishmentToString());
        System.out.println(punishment);
        System.out.println(punishment1.StudentpunishmentToString());
        System.out.println(punishment1);
    }

    @Test
    public void findAllPunishment() {
        List<Punishment> list = punishmentService.findAllPunishmentByLevel(1);
        for (Punishment pun: list) {
            System.out.println(pun.StudentpunishmentToString());
        }
    }

    @Test
    public void updatePunishment() {
        Punishment punishment = new Punishment("0", "2005040236", 0, date, "F", "浅浅修改一下内容");
        int count = punishmentService.updatePunishment(punishment);
        System.out.println(count);
    }

    /**
     * 成绩模块测试
     */
    @Test
    public void addGrade() {
        Grade grade = new Grade("0", "2005040203", 99, 99, 95, 90);
        int count = gradeService.addGrade(grade);
        System.out.println(count);
    }

    @Test
    public void findAllGrade() {
        List<Grade> list = gradeService.findAllGrade();
        for (Grade grade: list) {
            System.out.println(grade.StudentGradeToString());
        }
    }

    @Test
    public void findOneGradeToId() {
        List<Grade> gradeList = gradeService.findOneGradeToId("2005040206");
        for (Grade grade: gradeList) {
            System.out.println(grade.StudentGradeToString());
            System.out.println(grade);
        }
        String className = IDTransformation.classId2className(gradeList.get(0).getStudent().getClassId());
        String departmentName = IDTransformation.departmentId2departmentName(gradeList.get(0).getStudent().getDepartmentId());
        Student student = gradeList.get(0).getStudent();
        student.setClassId(className);
        student.setDepartmentId(departmentName);
        Grade grade = new Grade("0", student.getStudentId(), gradeList.get(0).getMathGrade(), gradeList.get(0).getJavaGrade(), gradeList.get(0).getEnglishGrade(), gradeList.get(0).getSportGrade(), gradeList.get(0).getStudent());
        System.out.println(grade);
        System.out.println(grade.StudentGradeToString());
    }

    @Test
    public void findOneGradeToName() {
        List<Grade> gradeList = gradeService.findOneGradeToName("龙");
        for (Grade grade: gradeList) {
            System.out.println(grade.StudentGradeToString());
        }
    }

    @Test
    public void findAvgGrade() {
        GradeAvg gradeAvg = gradeService.findAverageScores();
        System.out.println(gradeAvg);
    }

    @Test
    public void findAllGradeTable() {
        List<GradeTable> gradeTable = gradeService.findAllGradeTable();
        for (GradeTable grade: gradeTable) {
            System.out.println(grade);
        }
    }

    @Test
    public void updateGrade() {
        Grade grade = new Grade("0", "2005040239", 99, 99, 95, 90);
        int count = gradeService.updateGrade(grade);
        System.out.println(count);
    }

    /**
     * 用户、角色与授权模块
     */
    @Test
    public void findByUsername() {
        UserInfo user = userService.findByUsername("廖子豪");
        System.out.println(user);
    }

    /**
     * 选课模块
     */
    @Test
    public void findAllCourse() {
        List<Course> courseList = courseService.findAllCourse();
        for (Course course: courseList) {
            System.out.println(course);
        }
    }

    @Test
    public void addSelectCourse() {
        int count = courseService.addSelectCourse("2005040224", "008");
        System.out.println(count);
    }

    @Test
    public void findCourseByCId() {
        Course course = courseService.findCourseByCId("027");
        System.out.println(course);
    }

    @Test
    public void findCourseTableByOneStudent() {
        CourseTable courseTable = courseService.findCourseTableByOneStudent("2005040206");
        System.out.println(courseTable);
    }

    /**
     * ID转换测试
     */
    @Test
    public void IDTransformation() {
        String courseJspName = IDTransformation.courseName2JspStr("周一9-10节");
        System.out.println(courseJspName);
    }

    /**
     * 成绩模块
     */
    @Test
    public void findAllScoreByOneStudent() {
        List<Score> scoreList = courseService.findAllScoreByOneStudent("2005040206");
        for (Score score: scoreList) {
            System.out.println(score);
            System.out.println(score.getScoreStr());
        }
    }

    @Test
    public void findAllScoreByOneStudent2() {
        int gpa = 0;
        int allCredit = courseService.creditHourTotalBySid("2005040206");
        List<Score> scoreList = courseService.findAllScoreByOneStudent("2005040206");

        List<Map<String, String>> dataList = new ArrayList<>();

        for (Score score: scoreList) {
            if (score.getScore() != null) {
                Map<String, String> dataMap = new HashMap<>();
                gpa = gpa + score.getScore() * score.getCredit_hour();
                Double scoreCredit = (double)score.getScore() * score.getCredit_hour() / allCredit;
                long scoreCreditRound = Math.round(scoreCredit);
                System.out.println(scoreCreditRound);
                dataMap.put("label", score.getCourseName());
                dataMap.put("value", Double.toString(scoreCredit));
                dataList.add(dataMap);
            }
        }

        JSONArray jsonArray = new JSONArray(dataList);
        System.out.println(jsonArray);
    }

    /**
     * 老师模块
     */
    @Test
    public void addTeaCourse() {
        Course course = new Course("033", "测试", "20220603", 1, 2, "都行", "嘿嘿", "huhuhu", 3, 20);
        int count = teacherService.addTeaCourse(course);
    }

    @Test
    public void deleteCourse() {
        int count = teacherService.deleteTeaCourse("033");
        System.out.println(count);
    }

    @Test
    public void updateCourse() {
        Course course = new Course("033", "测试一下能不能修改", "20220603", 1, 2, "都行", "嘿嘿", "huhuhu", 3, 20);
        int count = teacherService.updateTeaCourse(course);
        System.out.println(count);
    }

    @Test
    public void findAllStuByCid() {
        List<Student> studentList = teacherService.findAllStuByCid("027");
        for (Student stu: studentList) {
            System.out.println(stu);
        }
    }

    @Test
    public void findCourseBySelf() {
        List<Course> courseList = teacherService.findCourseBySelf("20221002");
        for (Course course: courseList) {
            System.out.println(course);
        }
    }

    /**
     * 教务处模块
     */
    @Test
    public void findCourseByApply() {
        List<Course> courseList = educationService.findCourseByApply();
        for (Course course: courseList) {
            System.out.println(course);
        }
    }

}
