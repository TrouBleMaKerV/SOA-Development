package edu.nju.translate;

import edu.nju.model.scoreList.CourseScore;
import edu.nju.model.scoreList.Score;
import edu.nju.model.scoreList.ScoreList;
import edu.nju.model.student.ScoreInfo;
import edu.nju.model.student.StudentList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Translate {
    public static ScoreList convert(StudentList studentList) {
        ScoreList scoreList = new ScoreList();
        List<ScoreInfo> tempScoreInfo = new ArrayList<>();
        for(int i = 0;i<studentList.getStudents().size();i++){
            tempScoreInfo.addAll(studentList.getStudents().get(i).getScoreInfos());
        }
        List<ScoreList> tempScoreList = new ArrayList<>();
        for(int i = 0;i<tempScoreInfo.size();i++){
            tempScoreList .addAll(tempScoreInfo.get(i).getScoreLists());
        }
        List<CourseScore> tempList = new ArrayList<>();
        for(int i = 0 ;i < tempScoreList.size();i++){
            tempList.addAll(tempScoreList.get(i).getCourseScoreList());
        }
        List<CourseScore> resultList = new LinkedList<>();
        for (CourseScore courseScore: tempList) {
            boolean isRepeat = false;
            int repeatIndex = 0;
            for (; repeatIndex < resultList.size(); repeatIndex++) {
                CourseScore testScore = resultList.get(repeatIndex);
                if (testScore.getCid().equals(courseScore.getCid())
                        && testScore.getType().equals(courseScore.getType())) {
                    isRepeat = true;
                    break;
                }
            }
            if (isRepeat) {
                List<Score> scores = resultList.get(repeatIndex).getScoreList();
                scores.addAll(courseScore.getScoreList());
                scores.sort(Comparator.comparingInt(Score::getScore));
            } else {
                resultList.add(courseScore);
            }
        }
        resultList.sort(Comparator.comparingInt(c -> Integer.parseInt(c.getCid())));
        scoreList.setCourseScoreList(resultList);
        return scoreList;
    }

    public static ScoreList convert(ScoreList scoreList) {
        ScoreList result = new ScoreList();
        for(CourseScore courseScore : scoreList.getCourseScoreList()){
            CourseScore temp = new CourseScore();
            for (Score score: courseScore.getScoreList()) {
                if(score.getScore() < 60){
                    temp.addScore(score);
                }
            }
            if(!temp.getScoreList().isEmpty()){
                result.addCourseScore(temp);
            }
        }
        return result;
    }
}
