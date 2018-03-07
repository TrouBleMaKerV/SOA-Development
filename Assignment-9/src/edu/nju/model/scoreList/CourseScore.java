package edu.nju.model.scoreList;

import edu.nju.Common.NameSpace;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@XmlType(name = "课程成绩类型", namespace = NameSpace.JW_NAME_SPACE, propOrder = {"cName","cid","type","scoreList"})
@XmlAccessorType(value = XmlAccessType.FIELD)

public class CourseScore {

    @XmlAttribute(name = "课程名称")
    private String cName;

    @XmlAttribute(name = "课程编号")
    private String cid;

    @XmlAttribute(name = "成绩性质")
    private ScoreType type;

    @XmlElement(name = "成绩", namespace = NameSpace.JW_NAME_SPACE)
    private List<Score> scoreList;

    public CourseScore() {
        scoreList = new ArrayList<>();
    }

    public CourseScore(String cname,String cid, ScoreType type, List<Score> scoreList) {
        this.cName=cname;
        this.cid = cid;
        this.type = type;
        this.scoreList = scoreList;
    }

    public CourseScore(String cname,String cid, ScoreType type, String sid, int score) {
        Score scoreEntity = new Score(sid,score);
        scoreList = new ArrayList<>(1);
        scoreList.add(scoreEntity);
        this.cName=cname;
        this.cid = cid;
        this.type = type;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public ScoreType getType() {
        return type;
    }

    public void setType(ScoreType type) {
        this.type = type;
    }


    public List<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }

    public void addScore(Score score) {
        scoreList.add(score);
    }

}
