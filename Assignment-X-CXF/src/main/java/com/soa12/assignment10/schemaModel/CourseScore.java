package com.soa12.assignment10.schemaModel;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/26.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "课程成绩类型")
public class CourseScore {

    @XmlElement(name = "成绩")
    protected List<CourseScoreType> courseScoreTypes;
    @XmlAttribute(name = "课程编号")
    protected String cid;
    @XmlAttribute(name = "成绩性质")
    protected ScoreType scoreType;

    public CourseScore(){}

    public CourseScore(List<CourseScoreType> courseScoreTypes, String cid, ScoreType scoreType) {
        this.courseScoreTypes = courseScoreTypes;
        this.cid = cid;
        this.scoreType = scoreType;
    }

    public List<CourseScoreType> getCourseScoreTypes() {
        if (courseScoreTypes == null) {
            courseScoreTypes = new ArrayList<CourseScoreType>();
        }
        return this.courseScoreTypes;
    }


    public String getCid() {
        return cid;
    }


    public void setCid(String value) {
        this.cid = value;
    }


    public ScoreType getScoreType() {
        return scoreType;
    }


    public void setScoreType(ScoreType value) {
        this.scoreType = value;
    }

    public void setCourseScoreTypes(List<CourseScoreType> courseScoreTypes) {
        this.courseScoreTypes = courseScoreTypes;
    }
}

