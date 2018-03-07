package edu.nju.model.student;

import edu.nju.Common.NameSpace;
import edu.nju.model.scoreList.ScoreList;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType(name = "成绩详情",namespace = NameSpace.JW_NAME_SPACE)
@XmlAccessorType(value = XmlAccessType.FIELD)
public class ScoreInfo {

    @XmlAttribute(name = "学期",namespace = NameSpace.JW_NAME_SPACE)
    private TermType termType;

    @XmlElement(name = "课程成绩列表",namespace = NameSpace.JW_NAME_SPACE)
    private List<ScoreList> scoreLists;

    public ScoreInfo(){}

    public ScoreInfo(TermType type,List<ScoreList> scores){
        this.termType=type;
        this.scoreLists=scores;
    }

    public List<ScoreList> getScoreLists() {
        return scoreLists;
    }

    public void setScoreLists(List<ScoreList> scoreLists) {
        this.scoreLists = scoreLists;
    }

    public TermType getTermType() {
        return termType;
    }

    public void setTermType(TermType termType) {
        this.termType = termType;
    }
}
