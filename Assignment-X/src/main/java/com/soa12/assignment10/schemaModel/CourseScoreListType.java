package com.soa12.assignment10.schemaModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/26.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "课程成绩列表类型", propOrder = {
        "courseScores"
})
public class CourseScoreListType {

    @XmlElement(name = "课程成绩")
    protected List<CourseScore> courseScores;


    public List<CourseScore> getCourseScores() {
        if (courseScores == null) {
            courseScores = new ArrayList<CourseScore>();
        }
        return this.courseScores;
    }

    public void setCourseScores(List<CourseScore> courseScores) {
        this.courseScores = courseScores;
    }
}

