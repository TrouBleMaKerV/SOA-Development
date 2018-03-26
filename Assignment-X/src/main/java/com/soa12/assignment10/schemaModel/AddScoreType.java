package com.soa12.assignment10.schemaModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Administrator on 2018/3/26.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addScoreType", propOrder = {
        "scoreList"
})
public class AddScoreType {

    @XmlElement(name = "courseScoreListType",required = true)
    protected CourseScoreListType scoreList;


    public CourseScoreListType getScoreList() {
        return scoreList;
    }

    public void setScoreList(CourseScoreListType value) {
        this.scoreList = value;
    }

}
