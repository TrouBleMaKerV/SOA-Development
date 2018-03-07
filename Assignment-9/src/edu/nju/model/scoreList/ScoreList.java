package edu.nju.model.scoreList;

import edu.nju.Common.NameSpace;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "课程成绩列表" ,namespace = NameSpace.JW_NAME_SPACE)
@XmlAccessorType(XmlAccessType.FIELD)
public class ScoreList {

    @XmlElement(name = "课程成绩", namespace = NameSpace.JW_NAME_SPACE)
    private List<CourseScore> courseScoreList;

    public ScoreList() {
        courseScoreList = new ArrayList<>();
    }

    public List<CourseScore> getCourseScoreList() {
        return courseScoreList;
    }

    public void setCourseScoreList(List<CourseScore> courseScoreList) {
        this.courseScoreList = courseScoreList;
    }

    public void addCourseScore(CourseScore courseScore) {
        courseScoreList.add(courseScore);
    }
}
