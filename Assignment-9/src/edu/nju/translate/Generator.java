package edu.nju.translate;

import edu.nju.model.nju.Campus;
import edu.nju.model.nju.Department;
import edu.nju.model.nju.PersonInfo;
import edu.nju.model.nju.Sex;
import edu.nju.model.scoreList.CourseScore;
import edu.nju.model.scoreList.Score;
import edu.nju.model.scoreList.ScoreList;
import edu.nju.model.scoreList.ScoreType;
import edu.nju.model.student.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2018/3/7.
 */
public class Generator {


    public static StudentList generateData() {
        StudentList studentList = new StudentList();

        StudentStatus studentStatus = StudentStatus.有;
        Date date = new Date(2014);
        String id = "15125";
        String departID = "000001";
        String departName = "校学生会";
        String departPhone = "15850786300";
        String departLocation = "南京大学鼓楼校区南园6舍";
        String idList[] = new String[]{"141250204","141250019","141250002","141250104","141250210","141250173",
                "141250123","141250120","141250116","141250179","141250060","141250017"};
        String nameList[] = new String[]{"周聪","崔浩","白国风","阮威威","周颖婷","殷乾恩","潘凌伟","郑韵芝","孙婧","袁阳阳",
                "赖斌","陈自强"};

        for (int i = 0; i < idList.length; i++) {
            studentList.addStudent(new StudentInfo(
                    new StudentBasicInfo(idList[i], date, studentStatus,
                            new PersonInfo(nameList[i], date, Sex.男, id,
                                    new Department(departID, departName, departPhone, Campus.鼓楼, departLocation)
                            )
                    ),
                    generateRandomScore(idList[i]))
            );
        }

        return studentList;
    }

    private static List<ScoreInfo> generateRandomScore(String sid) {
        Random random = new Random();
        List<ScoreInfo> scoreList = new ArrayList<>(15);
        TermType termType = TermType.大三第一学期;

        ScoreType[] types = new ScoreType[]{ScoreType.平时成绩,ScoreType.期末成绩,ScoreType.总评成绩};

        String nameList[] = new String[]{"软件工程","体系结构","嵌入式","软件需求","微积分"};
        String idList[] = new String[]{"744209","979648","126809","557752","868674"};
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 3; j++) {

                int score = random.nextInt(100)%(100-50+1) + 50;

                Score score1 = new Score(sid, score);
                List<Score> list = new ArrayList<>();
                list.add(score1);
                CourseScore courseScore = new CourseScore(nameList[i], idList[i], types[j], list);
                List<CourseScore> courseScores = new ArrayList<>();
                courseScores.add(courseScore);
                List<ScoreList> socers = new ArrayList<>();
                socers.add(new ScoreList(courseScores));
                scoreList.add(new ScoreInfo(termType, socers));
            }
        }

        return scoreList;
    }

}
