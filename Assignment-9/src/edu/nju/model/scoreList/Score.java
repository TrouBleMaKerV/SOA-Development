package edu.nju.model.scoreList;


import edu.nju.Common.NameSpace;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "成绩细则", namespace = NameSpace.JW_NAME_SPACE)
@XmlAccessorType(value = XmlAccessType.FIELD)

public class Score {

    @XmlElement(name = "学号", namespace = NameSpace.JW_NAME_SPACE)
    private String sid;

    @XmlElement(name = "得分", namespace = NameSpace.JW_NAME_SPACE)
    private int score;

    public Score() {
    }

    public Score(String sid, int score) {
        this.sid = sid;
        this.score = score;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
