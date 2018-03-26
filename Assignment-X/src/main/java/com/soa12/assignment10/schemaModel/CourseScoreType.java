package com.soa12.assignment10.schemaModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Administrator on 2018/3/26.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "成绩细则", propOrder = {
        "sid",
        "score"
})
public class CourseScoreType {

    @XmlElement(name = "学号", required = true)
    protected String sid;
    @XmlElement(name = "分数")
    protected int score;


    public String getSid() {
        return sid;
    }


    public void setSid(String value) {
        this.sid = value;
    }


    public int getScore() {
        return score;
    }


    public void setScore(int value) {
        this.score = value;
    }
}